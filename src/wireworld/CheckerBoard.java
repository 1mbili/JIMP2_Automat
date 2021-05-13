package wireworld;

import java.awt.*;

import javax.swing.JPanel;

public class CheckerBoard extends JPanel {

    private int[][] matrixBoard;

    public CheckerBoard () {
        matrixBoard = WireworldTest.getBoard();
    }

//    @Override
//    public void paint(Graphics g) {
//        Graphics2D g2d = (Graphics2D) g;
//        g2d.drawOval(0, 0, 100, 100);
//    }

    @Override
    public void paint(Graphics g) {
        //super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int maxRow = matrixBoard.length - 1;
        int maxCol = matrixBoard[maxRow].length - 1;


        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                //g2d.drawRect(row * 10, column * 10, 10, 10);
                g2d.drawOval(row + 3, column + 3, 1,1);
//                int data = matrixBoard[row][column];
//                Colors colors = new Colors();
//                colors.setData(data);
//
//                Square square = new Square();
//                square.setColor(colors.getColor());
//                Rectangle drawingRectangle = square.getDrawingRectangle();
//                g2d.setColor(square.getColor());
//                g2d.setColor(BLACK);
                //g2d.fillRect(row * 10, column * 10, 10, 10);
                //g.fillRect(drawingRectangle.x, drawingRectangle.y, drawingRectangle.width, drawingRectangle.height);
            }
        }
    }

    public class Colors {

        private int data;
        private Color color;

        public Colors() {
        }

        public void setData(int data) {
            this.data = data;
        }

        public Color getColor() {
            switch(data) {
                case 0:
                    return color.WHITE;
                case 1:
                    return color.YELLOW;
                case 2:
                    return color.RED;
                case 3:
                    return color.BLUE;
                default:
                    break;
            }
            return null;
        }
    }

    public class Square {
        private Color color;
        private Point coordinate;
        private Rectangle drawingRectangle;

        public Square() {

        }

        public Point getCoordinate() {
            return coordinate;
        }

        public void setCoordinate(Point coordinate) {
            this.coordinate = coordinate;
        }

        public Rectangle getDrawingRectangle() {
            return drawingRectangle;
        }

        public void setDrawingRectangle(Rectangle drawingRectangle) {
            this.drawingRectangle = drawingRectangle;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }
    }

}