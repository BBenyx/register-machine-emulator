package factories
import factorySupport.ArgumentHandler
import factorySupport.FileReader
import factorySupport.InputHandler
import factorySupport.ParserCreatorInit
import machines.RegisterMachine
import registerDataHolders.InputTape
import registerDataHolders.ProgramCounter

class RegisterMachineFactory(val arguments: Array<String>): Factory<RegisterMachine> {

    override fun create(): RegisterMachine {
        require(arguments.isNotEmpty()) {"ERROR! Program path must be given!"}

        val rawProgramLines = FileReader().readFile(arguments[0])
        val input = if (arguments.size > 1) {
            arguments[1]
        } else {
            InputHandler().getNonBlankInput()
        }

        val inputTape: InputTape = ArgumentHandler().getInputTape(input)
        val memory: ArrayList<Int> = arrayListOf()
        val programCounter = ProgramCounter(0u)

        val commandCreators = ParserCreatorInit().getCommandCreators(memory, inputTape, programCounter)
        val program = ArgumentHandler().getProgramFrom(rawProgramLines, commandCreators)

        return RegisterMachine(program, programCounter, memory, inputTape)
    }
}