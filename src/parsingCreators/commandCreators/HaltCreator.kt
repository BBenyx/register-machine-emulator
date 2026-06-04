package parsingCreators.commandCreators
import commands.Command
import commands.Halt
import operands.Operand
import parsingCreators.CommandCreator
import registerDataHolders.ProgramCounter

class HaltCreator(val programCounter: ProgramCounter): CommandCreator {

    override fun compatible(value: String?): Boolean {
        return value == "HALT"
    }

    override fun create(address: Operand?): Command {
        return Halt(programCounter)
    }
}