package parsingCreators.commandCreators
import commands.Command
import commands.Store
import operands.AddressOperand
import operands.Operand
import parsingCreators.CommandCreator

class StoreCreator(val memory: ArrayList<Int>): CommandCreator {

    override fun compatible(value: String?): Boolean {
        return value == "STORE"
    }

    override fun create(address: Operand?): Command {
        require(address != null) {"ERROR! Store command cannot be created with a null address: $address"}
        require(address is AddressOperand) {"ERROR! Store command cannot be created with an immediate address: $address"}

        return Store(address, memory)
    }
}