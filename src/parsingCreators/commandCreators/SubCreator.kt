package parsingCreators.commandCreators
import commands.Command
import commands.Sub
import operands.Operand
import parsingCreators.CommandCreator

class SubCreator(val memory: ArrayList<Int>): CommandCreator {

    override fun compatible(value: String?): Boolean {
        return value == "SUB"
    }

    override fun create(address: Operand?): Command {
        require(address != null) {"ERROR! Sub command cannot be created with a null address: $address"}

        return Sub(address, memory)
    }
}