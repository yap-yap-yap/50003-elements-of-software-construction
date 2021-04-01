import random
import sys
import binascii

class Mutator:
    def mutation(self, input_string):
        function_list = []
        for f in dir(Mutator):
            if f.startswith("mutate"):
                function_list.append(f)
        
        chosen_mutation = random.choice(function_list)
        #print(chosen_mutation)
        return getattr(Mutator, chosen_mutation)(self, input_string)


    def mutate_swap(self, input_string):
        input_list = list(input_string)

        char_1 = random.randrange(0, len(input_list))
        char_2 = random.randrange(0, len(input_list))
        input_list[char_1], input_list[char_2] = input_list[char_2], input_list[char_1]
        output = "".join(input_list)
        return output

    def mutate_bitflip(self, input_string):
        
        bits = bin(int.from_bytes(input_string.encode(), 'big'))
        #print(bits)
        input_list = list(bits)
        char = random.randrange(0, len(input_list))
        input_list[char] = str(int(not bool(input_list[char])))
        mutated_bits = "".join(input_list)
        #print(mutated_bits)
        #print(bits == mutated_bits)
        output_int = int(mutated_bits, 2)
        return output_int.to_bytes((output_int.bit_length() + 7) // 8, 'big').decode()

    def mutate_trim(self, input_string):
        char_1 = random.randrange(0, len(input_string))
        char_2 = random.randrange(0, len(input_string))
        if char_1 > char_2:
            start = char_2
            end = char_1
        else:
            start = char_1
            end = char_2
        return input_string[start:end]


if len(sys.argv) < 2:
    raise ValueError("input: python mutator.py input_file_path")
oldfile = open(sys.argv[1], 'r')
newfile = open("mutated_"+sys.argv[1], 'a')

line = oldfile.readline() 
while line:
    mutated_line = Mutator().mutation(line)
    #print(mutated_line)
    newfile.write(mutated_line)
    line = oldfile.readline()
oldfile.close()
newfile.close()


