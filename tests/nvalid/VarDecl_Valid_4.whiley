import println from whiley.lang.System

function constantPool() => int:
    return 12478623847120981

method main(System.Console sys) => void:
    constantPool = constantPool()
    sys.out.println("GOT: " + Any.toString(constantPool))