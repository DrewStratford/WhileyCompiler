import println from whiley.lang.System

type sr6nat is int

type sr6tup is {sr6nat f, int g}

method main(System.Console sys) => void:
    x = {f: 1, g: 5}
    x.f = 2
    sys.out.println(Any.toString(x))