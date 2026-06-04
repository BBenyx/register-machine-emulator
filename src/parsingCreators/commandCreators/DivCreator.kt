package parsingCreators.commandCreators
import commands.Command
import commands.Div
import operands.Operand
import parsingCreators.CommandCreator

class DivCreator(val memory: ArrayList<Int>): CommandCreator {

    override fun compatible(value: String?): Boolean {
        return value == "DIV"
    }

    override fun create(address: Operand?): Command {
        require(address != null) {"ERROR! Div command cannot be created with a null address: $address"}

        return Div(address, memory)
    }
}