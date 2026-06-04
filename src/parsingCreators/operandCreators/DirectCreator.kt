package parsingCreators.operandCreators
import operands.DirectAddress
import operands.Operand
import parsingCreators.OperandCreator

class DirectCreator: OperandCreator {

    override fun compatible(value: String?): Boolean {
        try {
            value!!.toUInt()
            return true
        } catch (e: Exception) {
            return false
        }
    }

    override fun create(address: String?): Operand {
        require(compatible(address)) {"ERROR! Direct operand creation called for a non-direct address: $address"}
        return DirectAddress(address!!.toUInt())
    }
}