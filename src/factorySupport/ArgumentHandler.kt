package factorySupport
import commands.Command
import operands.Operand
import parsingCreators.CommandCreator
import parsingCreators.OperandCreator
import registerDataHolders.InputTape

class ArgumentHandler {

    fun getInputTape(input: String): InputTape {
        return InputTape(0u, input.trim().toIntList())
    }

    fun getProgramFrom(rawLines: List<String>, commandCreators: List<CommandCreator>): List<Command> {
        val labels = getLabelPairs(rawLines)
        val instructions = removeLabels(rawLines)
        val operandCreators = ParserCreatorInit().getOperandCreators()

        val program: ArrayList<Command> = arrayListOf()

        for (line in instructions) {
            val splitted = line.split(" ")
            val operand = if (splitted.size > 2) {
                getOperand(
                    splitted[0],
                    splitted[1] + splitted[2],
                    labels,
                    operandCreators,)
            } else if (splitted.size == 1) {
                getOperand(
                    splitted[0],
                    null,
                    labels,
                    operandCreators,)
            } else {
                getOperand(
                    splitted[0],
                    splitted[1],
                    labels,
                    operandCreators,)
            }

            val command = getCommand(splitted[0], operand, commandCreators)
            program.add(command)
        }
        return program
    }

    private fun getOperand(instructionName: String, _value: String?, labels: List<LabelPair>, creators: List<OperandCreator>): Operand {
        val value: String? = if (instructionName == "JUMP" || instructionName == "JGTZ" || instructionName == "JZERO") {
            require(_value != null) {"ERROR! At jump instructions there must be an address!"}
            '=' + getLabelIndex(labels, _value).toString()
        } else {
            _value
        }
        //println(value)

        for (creator in creators) {
            if (creator.compatible(value)) {
                return creator.create(value)
            }
        }
        throw IllegalArgumentException("ERROR! Undefined operand given: $value")
    }

    private fun getCommand(name: String, operand: Operand, creators: List<CommandCreator>): Command {
        for (creator in creators) {
            if (creator.compatible(name)) {
                return creator.create(operand)
            }
        }
        throw IllegalArgumentException("ERROR! Undefined instruction name given: $name")
    }

    private fun getLabelPairs(list: List<String>): List<LabelPair> {
        val labels: ArrayList<LabelPair> = arrayListOf()

        for (i in 0..<list.size) {
            val possibleLabel: String = list[i].split(" ")[0]

            if (possibleLabel[possibleLabel.length-1] == ':') {
                labels.add(LabelPair(possibleLabel.trim(':'), i.toUInt()))
            }
        }
        return labels
    }

    private fun getLabelIndex(list: List<LabelPair>, target: String): UInt {
        for (i in 0..<list.size) {
            if (list[i].label == target) {
                return list[i].instructionNumber
            }
        }
        throw IllegalArgumentException("Target is not in list!")
    }

    private fun removeLabels(list: List<String>): List<String> {
        val newList: ArrayList<String> = arrayListOf()
        for (elem in list) {
            if (elem.split(':').size > 1) {
                newList.add(elem.split(':')[1].trim())
            } else {
                newList.add(elem)
            }
        }
        return newList
    }

    private fun String.toIntList(): List<Int> {
        val integers: ArrayList<Int> = arrayListOf()
        try{
            for (i in this) {
                integers.add(i.toString().toInt())
            }
        } catch (e: Exception) {
            throw IllegalArgumentException("ERROR! Non-integer input found: $this")
        }
        return integers
    }
}