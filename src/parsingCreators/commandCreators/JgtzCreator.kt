package parsingCreators.commandCreators
import commands.Command
import commands.Jgtz
import operands.Operand
import operands.ValueOperand
import parsingCreators.CommandCreator
import registerDataHolders.ProgramCounter

class JgtzCreator(val memory: ArrayList<Int>, val programCounter: ProgramCounter): CommandCreator {

    override fun compatible(value: String?): Boolean {
        return value == "JGTZ"
    }

    override fun create(address: Operand?): Command {
        require(address != null) {"ERROR! Jgtz command cannot be created with a null address: $address"}
        require(address is ValueOperand) {"ERROR! Jgtz command cannot be created with non-immediate address: $address"}

        return Jgtz(address, programCounter, memory)
    }
}