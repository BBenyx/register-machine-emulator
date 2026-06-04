package parsingCreators
import commands.Command
import operands.Operand

interface CommandCreator: ParsingCreator {
    fun create(address: Operand?): Command
}