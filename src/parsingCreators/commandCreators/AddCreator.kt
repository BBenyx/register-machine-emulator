package parsingCreators.commandCreators
import commands.Command
import commands.Add
import operands.Operand
import parsingCreators.CommandCreator

class AddCreator(val memory: ArrayList<Int>): CommandCreator {

    override fun compatible(value: String?): Boolean {
        return value == "ADD"
    }

    override fun create(address: Operand?): Command {
        require(address != null) {"ERROR! Add command cannot be created with a null address: $address"}

        return Add(address, memory)
    }
}