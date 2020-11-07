package com.company;

public class Main {

    public Main MainClass;
    final public int x_define = 9; //10 in massive
    final public int y_define = 9;
    final public int b1 = 3;
    final public int s1 = 2;
    final public int s2 = 3;
    final public char FILL = '#';
    final public char UNFILLED = '*';

    char[][] mass_income = new char[y_define][x_define];
    char[][] mass_outcome = new char[y_define][x_define];

    public int neighbors_counter(char[][] mass, int y_outside, int x_outside) {
        int number_of_neighbors = 0;
        /*int y = y_outside;
        int x = x_outside;*/

        if ((y_outside - 1) >= 0 && mass[y_outside - 1][x_outside] == FILL) number_of_neighbors++;

        if ((y_outside - 1) >= 0 && (x_outside + 1) <= x_define && mass[y_outside - 1][x_outside + 1] == FILL) number_of_neighbors++;
        if ((x_outside + 1) <= x_define && mass[y_outside][x_outside + 1] == FILL) number_of_neighbors++;

        if ((y_outside + 1) <= y_define && (x_outside + 1) <= x_define && mass[y_outside + 1][x_outside + 1] == FILL) number_of_neighbors++;
        if ((y_outside + 1) <= y_define && mass[y_outside + 1][x_outside] == FILL) number_of_neighbors++;

        if ((y_outside + 1) <= y_define && (x_outside - 1) >= 0 && mass[y_outside + 1][x_outside - 1] == FILL) number_of_neighbors++;
        if ((x_outside - 1) >= 0 && mass[y_outside][x_outside - 1] == FILL) number_of_neighbors++;

        if ((y_outside - 1) >= 0 && (x_outside - 1) >= 0 && mass[y_outside - 1][x_outside - 1] == FILL) number_of_neighbors++;

        return number_of_neighbors;
    }

    public boolean cell_death(char[][] mass_outcome, int y_outside, int x_outside) {
        mass_outcome[y_outside][x_outside] = UNFILLED;
        return true;
    }

    public boolean cell_remains(char[][] mass_outcome, int y_outside, int x_outside) {
        mass_outcome[y_outside][x_outside] = FILL;
        return true;
    }

    public boolean cell_survival(char[][] mass_income, char[][] mass_outcome, int y_outside, int x_outside){
        if (neighbors_counter(mass_income, y_outside, x_outside) == s1 || neighbors_counter(mass_income, y_outside, x_outside) == s2)
        {
            cell_remains(mass_outcome, y_outside, x_outside);
            //noting to do, may be + to score?
        }
        if (neighbors_counter(mass_income, y_outside, x_outside) > s2)
        {
            cell_death(mass_outcome, y_outside, x_outside);
        }
        if (neighbors_counter(mass_income, y_outside, x_outside) < s1)
        {
            cell_death(mass_outcome, y_outside, x_outside);
        }
        return true;
    }

    public boolean cell_birth(char[][] mass_income, char[][] mass_outcome, int y_outside, int x_outside) {
        if (neighbors_counter(mass_income, y_outside, x_outside) >= b1) {
            mass_outcome[y_outside][x_outside] = FILL;
            cell_survival(mass_income, mass_outcome, y_outside, x_outside);
        }
        return true;
    }

    public boolean life_period(char[][] mass_income, char[][] mass_outcome) {
        for (int y = 0; y <= y_define; y++) {
            for (int x = 0; x <= x_define; x++) {
                if (mass_income[y][x] == FILL) {
                    cell_survival(mass_income, mass_outcome, y, x);
                } else {
                    cell_birth(mass_income, mass_outcome, y, x);
                }
            }
        }
        return true;
    }

    public boolean cout_mass(char[][] mass_outcome) {
        for (int y = 0; y <= y_define; y++) {
            for (int x = 0; x <= x_define; x++) {
                System.out.print(mass_outcome[y][x]);
            }
            System.out.println();
        }
        return true;
    }

    public boolean fill_mass_with_unfill(char[][] mass) {
        for (int y = 0; y <= y_define; y++) {
            for (int x = 0; x <= x_define; x++) {
                mass[y][x] = UNFILLED;
            }
        }
        return true;
    }

    public boolean appropriation_mass(char[][] mass_income, char[][] mass_outcome) {
        for (int y = 0; y <= y_define; y++) {
            for (int x = 0; x <= x_define; x++) {
                mass_income[y][x] = mass_outcome[y][x];
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Main Game = new Main();
        char[][] mass_income = {
                {Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED},
                {Game.UNFILLED, Game.FILL, Game.FILL, Game.FILL, Game.FILL, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED},
                {Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED},
                {Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED},
                {Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED},
                {Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED},
                {Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED},
                {Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED},
                {Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED},
                {Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED},
        };
        char[][] mass_outcome = {
                {Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED},
                {Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED},
                {Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED},
                {Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED},
                {Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED},
                {Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED},
                {Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED},
                {Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED},
                {Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED},
                {Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED, Game.UNFILLED},
        };

        Game.fill_mass_with_unfill(mass_outcome);
        Game.cout_mass(mass_income);
        Game.appropriation_mass(mass_outcome, mass_income);

        System.out.println("==============================");

        for (int i = 0; i < 50; i++) {
            //cin >> i;
            Game.life_period(mass_income, mass_outcome);
            Game.cout_mass(mass_outcome);
            Game.appropriation_mass(mass_income, mass_outcome);
            Game.fill_mass_with_unfill(mass_outcome);
            System.out.println("==============================");
        }

    }
}
