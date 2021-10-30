package ru.geekbrains.java1.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

public class GameWindow extends JFrame {
    private static final int SIZE_OF_CELL = 70;

    private static final char EMPTY_SIGN = ' ';
    private static final char GAMER_SIGN = 'X';
    private static final char AI_SIGN = '0';

    private final int size; //размер игрового поля
    private final int dotsToWin; //длина выигрышной комбинации
    private boolean disableButtonHandler = false;

    private final char[][] map;
    private final JButton[][] cells;

    private final Random random;

    private class ButtonsActionListener implements ActionListener {
        private final int row;
        private final int column;

        public ButtonsActionListener(int row, int column) {
            this.row = row;
            this.column = column;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (disableButtonHandler) return;
            disableButtonHandler = true;
            if (!gamerMakesMove(row, column)) {
                disableButtonHandler = false;
                return;
            }
            printGameField();
            if (checkGameEnd(GAMER_SIGN)) return;
            aiMakesMove();
            printGameField();
            if (checkGameEnd(AI_SIGN)) return;
            disableButtonHandler = false;
        }
    }

    public GameWindow(int size, int dotsToWin) {
        this.size = size;
        this.dotsToWin = dotsToWin;
        map = new char[size][size];
        cells = new JButton[size][size];
        random = new Random();
        setBounds(10, 10, SIZE_OF_CELL * size, SIZE_OF_CELL * size);
        setTitle("Игра крестики-нолики");
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridLayout(size, size));
        Font font = new Font("Arial", Font.BOLD, 30);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = new JButton();
                cells[i][j].setFocusPainted(false);
                cells[i][j].setFont(font);
                cells[i][j].setForeground(Color.BLUE);
                cells[i][j].addActionListener(new ButtonsActionListener(i, j));
                add(cells[i][j]);
            }
        }
        createEmptyGameField();
        printGameField();
        setVisible(true);
    }

    /* ******************************************************************************
     условие победы для любого размера игрового поля и длины выигрышной комбинации
     *******************************************************************************/
    private boolean isWin(char sign) {
        int rowCounter;
        int columnCounter;
        int diagonalCounter11, diagonalCounter12;
        int diagonalCounter21, diagonalCounter22;
        for (int i = 0; i < size; i++) {
            diagonalCounter11 = diagonalCounter12 = diagonalCounter21 = diagonalCounter22 = 0;
            columnCounter = rowCounter = 0;
            for (int j = 0; j < size; j++) {
                rowCounter = map[i][j] == sign ? rowCounter + 1 : 0;
                columnCounter = map[j][i] == sign ? columnCounter + 1 : 0;
                if (rowCounter == dotsToWin || columnCounter == dotsToWin) return true;
                if (i + j < size) {
                    diagonalCounter11 = map[i + j][j] == sign ? diagonalCounter11 + 1 : 0;
                    diagonalCounter12 = map[j][i + j] == sign ? diagonalCounter12 + 1 : 0;
                    diagonalCounter21 = map[i + j][size - 1 - j] == sign ? diagonalCounter21 + 1 : 0;
                    diagonalCounter22 = map[j][size - 1 - j - i] == sign ? diagonalCounter22 + 1 : 0;
                    if (diagonalCounter11 == dotsToWin || diagonalCounter12 == dotsToWin
                            || diagonalCounter21 == dotsToWin || diagonalCounter22 == dotsToWin)
                        return true;
                }
            }
        }
        return false;
    }

    /* ****************************************************************************
                         получить список выигрышных ячеек
    ******************************************************************************/
    private int[] getWinDotsList(char sign) {
        int rowCounter;
        int columnCounter;
        int diagonalCounter11, diagonalCounter12;
        int diagonalCounter21, diagonalCounter22;
        int n;
        int[] result = new int[dotsToWin * 2];
        for (int i = 0; i < size; i++) {
            diagonalCounter11 = diagonalCounter12 = diagonalCounter21 = diagonalCounter22 = 0;
            columnCounter = rowCounter = 0;
            for (int j = 0; j < size; j++) {
                rowCounter = map[i][j] == sign ? rowCounter + 1 : 0;
                columnCounter = map[j][i] == sign ? columnCounter + 1 : 0;
                if (rowCounter == dotsToWin) {
                    for (j = 0, n = 0; j < size; j++) {
                        if (map[i][j] == sign) {
                            result[n++] = i;
                            result[n++] = j;
                            if (result.length <= n) break;
                        } else {
                            n = 0;
                        }
                    }
                    return result;
                }
                if (columnCounter == dotsToWin) {
                    for (j = 0, n = 0; j < size; j++) {
                        if (map[j][i] == sign) {
                            result[n++] = j;
                            result[n++] = i;
                            if (result.length <= n) break;
                        } else {
                            n = 0;
                        }
                    }
                    return result;
                }
                if (i + j < size) {
                    diagonalCounter11 = map[i + j][j] == sign ? diagonalCounter11 + 1 : 0;
                    diagonalCounter12 = map[j][i + j] == sign ? diagonalCounter12 + 1 : 0;
                    diagonalCounter21 = map[i + j][size - 1 - j] == sign ? diagonalCounter21 + 1 : 0;
                    diagonalCounter22 = map[j][size - 1 - j - i] == sign ? diagonalCounter22 + 1 : 0;
                    if (diagonalCounter11 == dotsToWin) {
                        for (j = 0, n = 0; j < size; j++) {
                            if (map[i + j][j] == sign) {
                                result[n++] = i + j;
                                result[n++] = j;
                                if (result.length <= n) break;
                            } else {
                                n = 0;
                            }
                        }
                        return result;
                    }
                    if (diagonalCounter12 == dotsToWin) {
                        for (j = 0, n = 0; j < size; j++) {
                            if (map[j][i + j] == sign) {
                                result[n++] = j;
                                result[n++] = i + j;
                                if (result.length <= n) break;
                            } else {
                                n = 0;
                            }
                        }
                        return result;
                    }
                    if (diagonalCounter21 == dotsToWin) {
                        for (j = 0, n = 0; j < size; j++) {
                            if (map[i + j][size - 1 - j] == sign) {
                                result[n++] = i + j;
                                result[n++] = size - 1 - j;
                                if (result.length <= n) break;
                            } else {
                                n = 0;
                            }
                        }
                        return result;
                    }
                    if (diagonalCounter22 == dotsToWin) {
                        for (j = 0, n = 0; j < size; j++) {
                            if (map[j][size - 1 - j - i] == sign) {
                                result[n++] = j;
                                result[n++] = size - 1 - j - i;
                                if (result.length <= n) break;
                            } else {
                                n = 0;
                            }
                        }
                        return result;
                    }
                }
            }
        }
        return null;
    }

    private boolean checkGameEnd(char sign) {
        if (isWin(sign)) {
            JOptionPane.showMessageDialog(this
                    , sign == GAMER_SIGN ? "Поздравляем! Вы выиграли!" : "Вы проиграли."
                    , "Игра окончена", JOptionPane.INFORMATION_MESSAGE);
            setTitle("Игра окончена");
            //выделить выигрышную последовательность
            int[] winDotsList = getWinDotsList(sign);
            for (int i = 0; i < winDotsList.length; i += 2)
                cells[winDotsList[i]][winDotsList[i + 1]].setForeground(Color.RED);
            return true;
        }
        if (checkNoEmptyFieldPositions()) {
            JOptionPane.showMessageDialog(this
                    , "Ничья."
                    , "Игра окончена", JOptionPane.INFORMATION_MESSAGE);
            setTitle("Игра окончена");
            return true;
        }
        return false;
    }

    private void createEmptyGameField() {
        for (char[] array : map) {
            Arrays.fill(array, EMPTY_SIGN);
        }
    }

    private void printGameField() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j].setText(Character.toString(map[i][j]));
            }
        }
    }

    private void aiMakesMove() {
        if (isAiMakesWinMove()) return; //завершающий победный ход компьютера
        if (isAiBlocksGamerWin()) return; //блокировка победного хода игрока
        int row, column;
        do {
            row = random.nextInt(size);
            column = random.nextInt(size);
        } while (map[row][column] != EMPTY_SIGN);
        map[row][column] = AI_SIGN;
    }

    /* *****************************************************
     компьютер блокирует победный ход игрока
     ******************************************************/
    private boolean isAiBlocksGamerWin() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == EMPTY_SIGN) {
                    map[i][j] = GAMER_SIGN;
                    if (isWin(GAMER_SIGN)) {
                        map[i][j] = AI_SIGN;
                        return true;
                    }
                    map[i][j] = EMPTY_SIGN;
                }
            }
        }
        return false;
    }

    /* ******************************************************
     завершающий победный ход компьютера
     *******************************************************/
    private boolean isAiMakesWinMove() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == EMPTY_SIGN) {
                    map[i][j] = AI_SIGN;
                    if (isWin(AI_SIGN)) return true;
                    map[i][j] = EMPTY_SIGN;
                }
            }
        }
        return false;
    }

    private boolean gamerMakesMove(int row, int column) {
        if (map[row][column] != EMPTY_SIGN) return false;
        map[row][column] = GAMER_SIGN;
        return true;
    }

    private boolean checkNoEmptyFieldPositions() {
        for (char[] array : map) {
            for (char cell : array) {
                if (cell == EMPTY_SIGN) return false;
            }
        }
        return true;
    }
}
