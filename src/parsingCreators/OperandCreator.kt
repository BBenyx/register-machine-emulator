package parsingCreators
import operands.Operand

interface OperandCreator: ParsingCreator {
    fun create(address: String?): Operand
}