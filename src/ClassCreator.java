class ClassCreator {

    static ISummator createSummator() {

        return new ISummator() {


            @Override
            public int plus(final int a, final int b) {
                return a + b;
            }

            @Override
            public int minus(final int a, final int b) {
                return a - b;
            }

            @Override
            public int mult(final int a, final int b) {
                return a * b;
            }

            @Override
            public double div(final int a, final int b) {
                return (double) a / (double) b;
            }

            @Override
            public int remDiv(final int a, final int b) {
                return a % b;
            }

            @Override
            public int pow(final int a, final int b) {
                if (b == 0)
                    return 1;
                return a * pow(a, b - 1);
            }
        };
        // BEGIN (write your solution here)

        // END

    }
}

