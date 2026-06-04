package parsingCreators.commandCreators
import commands.Command
import commands.Load
import operands.AddressOperand
import operands.Operand
import parsingCreators.CommandCreator

class LoadCreator(val memory: ArrayList<Int>): CommandCreator {

    override fun compatible(value: String?): Boolean {
        return value == "LOAD"
    }

    override fun create(address: Operand?): Command {
        require(address != null) {"ERROR! Load command cannot be created with a null address: $address"}
        require(address is AddressOperand) {"ERROR! Load command cannot be created with an immediate address: $address"}

        return Load(address, memory)
    }
}