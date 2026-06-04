import factories.RegisterMachineFactory

fun main(args: Array<String>) {
    val registerFactory = RegisterMachineFactory(args)
    val registerMachine = registerFactory.create()

    registerMachine.run()
}