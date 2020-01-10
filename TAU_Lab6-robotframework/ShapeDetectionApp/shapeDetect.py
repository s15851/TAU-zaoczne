class ShapeCalculator:
    def __init__(self, side1=None, side2=None, side3=None, side4=None):
        self.side1 = side1
        self.side2 = side2
        self.side3 = side3
        self.side4 = side4

    def check_triangle(self):
        if (self.side1 + self.side2 > self.side3) \
                or (self.side1 + self.side3 > self.side2) \
                or (self.side2 + self.side3 > self.side1):
            print("You can build the triangle.")
        else:
            print("You can't build the triangle.")

    def check_quadrangle(self):
        if max(self.side1, self.side2, self.side3, self.side4) \
                < (self.side1 + self.side2 + self.side3 + self.side4 -
                   max(self.side1, self.side2, self.side3, self.side4)):
            print("You can build the quadrangle.")
        else:
            print("You can't build the quadrangle.")

    def name_triangle(self):
        if (self.side1 == self.side2 and self.side2 != self.side3) \
                or (self.side1 == self.side3 and self.side3 != self.side2) \
                or (self.side2 == self.side3 and self.side3 != self.side1):
            print("Detect shape: Isosceles triangle")
        elif self.side1 == self.side2 == self.side3:
            print("Detect shape: Equilateral triangle")
        else:
            print("Detect shape: Multi-armed triangle")

    def name_quadrangle(self):
        if self.side1 == self.side2 == self.side3 == self.side4:
            print("Detect shape: Square")
        elif (self.side1 == self.side3 and self.side2 == self.side4) or \
                (self.side1 == self.side2 and self.side3 == self.side4) or \
                (self.side1 == self.side4 and self.side2 == self.side3):
            print("Detect shape: Rectangle")
        else:
            print("Detect shape: Quadrangle")


if __name__ == '__main__':
    calculator = ShapeCalculator()

    try:
        print("Enter float value of sides:")
        a = float(input("First side:    "))
        b = float(input("Second side:   "))
        c = float(input("Third side:    "))
        key = input("If you want to build a triangle ==> press 3, if you want to build a quadrangle ==> press 4:  ")
        if key == '3':
            ShapeCalculator(a, b, c).check_triangle()
            ShapeCalculator(a, b, c).name_triangle()
        elif key == '4':
            d = float(input("Fourth side:   "))
            ShapeCalculator(a, b, c, d).check_quadrangle()
            ShapeCalculator(a, b, c, d).name_quadrangle()
        else:
            print("Sorry, you have chosen a wrong key to build the figure. Try again!")
    except ValueError:
        print("You have to enter float value. Try again.")
