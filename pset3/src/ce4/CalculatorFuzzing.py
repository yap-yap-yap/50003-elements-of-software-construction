import random

def expression_extend():
    return random.choice(["Number Operator ", "Number"])

def operator_replace():
    return random.choice(["+","-","*","/","%"])

def number_replace():
    return random.choice(["Value", "Value.Value"])

def value_extend():
    return random.choice(["Digit", "DigitValue"])

def digit_replace():
    return str(random.randint(0, 9))

def CalculatorFuzzer():
    output = expression_extend()
    while output.endswith("Operator "):
        output = output + expression_extend()
    
    while "Operator" in output:
        output = output.replace("Operator", operator_replace(), 1)
    while "Number" in output:
        output = output.replace("Number", number_replace(), 1)
    while "Value" in output:
        output = output.replace("Value", value_extend(), 1)
    while "Digit" in output:
        output = output.replace("Digit", digit_replace(), 1)

    return output

print(CalculatorFuzzer())