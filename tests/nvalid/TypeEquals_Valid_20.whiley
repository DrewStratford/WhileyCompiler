import println from whiley.lang.System

function f({(int, any)} xs) => int:
    if xs is {(int, string)}:
        return 1
    else:
        return -1

method main(System.Console sys) => void:
    s1 = {(1, "Hello")}
    s2 = {(1, "Hello"), (1, "World")}
    s3 = {(1, "Hello"), (2, "Hello")}
    s4 = {(1, 1), (2, 2)}
    s5 = {(1, 1), (2, "Hello")}
    sys.out.println(Any.toString(f(s1)))
    sys.out.println(Any.toString(f(s2)))
    sys.out.println(Any.toString(f(s3)))
    sys.out.println(Any.toString(f(s4)))
    sys.out.println(Any.toString(f(s5)))