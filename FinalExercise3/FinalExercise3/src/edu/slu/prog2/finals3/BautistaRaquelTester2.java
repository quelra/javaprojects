package edu.slu.prog2.finals3;
/*
 * Name: BAUTISTA, Raquel S.
 * Date: May 16, 2020
 * 9378A CS 122
 * 9378B CS 122L
 */
import java.util.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 * A GUI program for getting the area and volume of geometric shapes and solid.
 */
public class BautistaRaquelTester2 extends JFrame{

    private JMenu mainMenuChoiceForArea;
    private JMenu mainMenuChoiceForVolume;
    private JMenu mainMenuExitChoice;
    private JMenu subMenu;

    private JMenuItem itemCircle;
    private JMenuItem itemTriangle;
    private JMenuItem itemSquare;
    private JMenuItem itemRectangle;
    private JMenuItem itemRectangularSolid;
    private JMenuItem itemCylinder;

    private JFrame frameForCircle;
    private JFrame frameForTriangle;
    private JFrame frameForRectangle;
    private JFrame frameForSquare;
    private JFrame frameForRectangularSolid;
    private JFrame frameForCylinder;

    private Shape shape;

    public static void main(String[] args){
        BautistaRaquelTester2 program;
        try {
            program = new BautistaRaquelTester2();
        } catch(Exception exx){
            exx.printStackTrace();
        }
    }

    /**
     * Initiates the GUI for the program.
     * Creation of title, labels, menus, submenus and adding of listeners.
     * 1. The labels explains the purpose of the program and includes the time and date.
     * 2. The main menu choices are AREA, VOLUME and EXIT.
     * 3. Under the AREA of geometric figure menu, are the items area of circle, area of triangle and a sub menu for area of rectangle and square.
     * 4. Under the VOLUME of solid menu, are the items volume of rectangular solid and cylinder.
     */
    public BautistaRaquelTester2() throws Exception{
        setTitle("Computations of Areas and Volumes" );

        JPanel mainPanel = new JPanel();
        mainPanel.setFont(new Font(Font.SANS_SERIF, Font.BOLD,60));
        mainPanel.setLayout(new GridLayout(8,1));
        JLabel mainLabel1 = new JLabel("Hello User!");
        JLabel mainLabel2 = new JLabel("This application helps you compute the area or volume of a geometric figure or solid.");
        JLabel mainLabel3 = new JLabel("Please choose the desired computation from the menu.");
        JLabel mainLabel6 = new JLabel("----------------------------------------------------------------------------------------");
        JLabel mainLabel7 = new JLabel("Close the window showing the data for a geometric figure or solid before choosing another figure or solid.");
        JLabel mainLabel8 = new JLabel("----------------------------------------------------------------------------------------");
        JLabel mainLabel4 = new JLabel("Programmer: Bautista, Raquel");
        GregorianCalendar dateToday = new GregorianCalendar();
        String today = "Today is "+ dateToday.getTime() +".";
        JLabel mainLabel5 = new JLabel(today);
        mainPanel.add(mainLabel5);
        mainPanel.add(mainLabel1);
        mainPanel.add(mainLabel2);
        mainPanel.add(mainLabel3);
        mainPanel.add(mainLabel6);
        mainPanel.add(mainLabel7);
        mainPanel.add(mainLabel8);
        mainPanel.add(mainLabel4);
        add(mainPanel);


        JMenuBar mb = new JMenuBar();
        mainMenuChoiceForArea = new JMenu("AREA of a Geometric Figure");
        mainMenuChoiceForVolume = new JMenu("VOLUME of a solid");

        mainMenuExitChoice = new JMenu("Exit");
        mainMenuExitChoice.addMenuListener(new MenuListener() {
            public void menuSelected(MenuEvent e) {
                System.exit(0);
            }
            public void menuDeselected(MenuEvent e) {
                System.out.println("menuDeselected");
            }
            public void menuCanceled(MenuEvent e) {
                System.out.println("menuCanceled");
            }
        });


        subMenu = new JMenu("Area of a Four-sided Polygon");
        itemCircle=new JMenuItem("Area of a Circle");

        itemCircle.addActionListener((e)-> {
            try {
                showCircleUI();

            } catch (Exception ex){
                ex.printStackTrace();
            }

        });
        itemTriangle=new JMenuItem("Area of a Triangle");
        itemTriangle.addActionListener((e)-> {
            try {
                showTriangleUI();
            } catch (Exception e2){
                e2.printStackTrace();
            }
        });
        itemRectangle=new JMenuItem("Area of a Rectangle");
        itemRectangle.addActionListener((e)-> {
            try {
                showRectangleUI();
            } catch (Exception e3){
                e3.printStackTrace();
            }
        });
        itemSquare=new JMenuItem("Area of a Square");
        itemSquare.addActionListener((e)-> {
            try {
                showSquareUI();
            } catch (Exception e4){
                e4.printStackTrace();
            }
        });
        itemRectangularSolid=new JMenuItem("Volume of a Rectangular Solid");
        itemRectangularSolid.addActionListener((e)->{
            try {
                showRectangularSolidUI();
            } catch (Exception e5){
                e5.printStackTrace();
            }
        });
        itemCylinder=new JMenuItem("Volume of a Cylinder");
        itemCylinder.addActionListener((e)->{
            try{
                showCylinderUI();
            }catch (Exception e6){
                e6.printStackTrace();
            }
        });

        mainMenuChoiceForArea.add(itemCircle);
        mainMenuChoiceForArea.add(itemTriangle);
        mainMenuChoiceForVolume.add(itemRectangularSolid);
        mainMenuChoiceForVolume.add(itemCylinder);

        subMenu.add(itemRectangle);
        subMenu.add(itemSquare);
        mainMenuChoiceForArea.add(subMenu);

        mb.add(mainMenuChoiceForArea);
        mb.add(mainMenuChoiceForVolume);
        mb.add(mainMenuExitChoice);

        setJMenuBar(mb);
        setSize(500,500);
        pack();

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    /**
     * The method that shows UI of getting the area of a circle when the menuItem area of a circle is chosen.
     * 1. Shows a label that prompts user to input the radius.
     * 2. Includes text field for inputting the radius.
     * 3. A button for getting the area. Inputs must not be empty and are valid numbers.
     * 4. A text field for displaying the result of the area based from the given radius.
     */
    private void showCircleUI(){
        frameForCircle = new JFrame("Area of a Circle");
        JPanel circlePanel = new JPanel();
        JLabel radiusInputLabel = new JLabel("Enter the radius of the circle ");
        JTextField radiusInputTextField = new JTextField(20);
        JTextField circleOutputTextField = new JTextField(60);
        circleOutputTextField.setEditable(false);
        JButton circleOutputButton = new JButton("Click to show area of the circle");
        circlePanel.setLayout(new GridLayout(2,1));
        circlePanel.add(radiusInputLabel);
        circlePanel.add(radiusInputTextField);
        circlePanel.add(circleOutputButton);
        circlePanel.add(circleOutputTextField);

        circleOutputButton.addActionListener((e) -> {
                    if (!radiusInputTextField.getText().equals("")) {
                        try{
                            double radius = Double.parseDouble(radiusInputTextField.getText());
                            shape = new Circle("circle", radius);
                            if (shape instanceof Circle)
                                circleOutputTextField.setText("The area of " + ((Circle) shape).toString() + " is " + ((Circle) shape).area() + " square units.");
                            else
                                circleOutputTextField.setText("No circle has been instantiated.");
                        } catch (NumberFormatException x){
                            circleOutputTextField.setText("Invalid Input. Input must be in number format");
                        }
                    }
                    else
                        circleOutputTextField.setText("You have to enter the radius of the circle.");
                }
        );


        frameForCircle.getContentPane().add(circlePanel);
        frameForCircle.pack();
        frameForCircle.setVisible(true);
        frameForCircle.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


    } // end showCircleUI method

    /**
     * The user interface of getting the area of a triangle.
     * This includes:
     * 1. Input labels prompting the user to input the lengths of the 3 sides of the triangle.
     * 2. Text fields where the user will input the value of lengths.
     * 3. Button to get the result. Inputs must not be empty and are valid numbers.
     * 4. Text field that displays the result.
     *      The lengths inputted must form a valid triangle meaning the sum of any two sides must be greater than the other one side.
     *
     */
    private void showTriangleUI(){
        frameForTriangle = new JFrame("Area of a Triangle");

        JLabel inputLabel1 = new JLabel("Enter the length of the first side of the triangle");
        JLabel inputLabel2 = new JLabel("Enter the length of the second side of the triangle");
        JLabel inputLabel3 = new JLabel("Enter the length of the third side of the triangle");

        JTextField side1TextField = new JTextField(20);
        JTextField side2TextField = new JTextField(20);
        JTextField side3TextField = new JTextField(20);
        JButton triangleOutputButton = new JButton("Click to show area of the triangle");
        JTextField triangleOutputTextField = new JTextField(60);
        triangleOutputTextField.setEditable(false);

        JPanel trianglePanel = new JPanel();
        trianglePanel.setLayout(new GridLayout(4,2));

        trianglePanel.add(inputLabel1);
        trianglePanel.add(side1TextField);
        trianglePanel.add(inputLabel2);
        trianglePanel.add(side2TextField);
        trianglePanel.add(inputLabel3);
        trianglePanel.add(side3TextField);
        trianglePanel.add(triangleOutputButton);
        trianglePanel.add(triangleOutputTextField);

        triangleOutputButton.addActionListener((e)->{
            if (side1TextField.getText().equals("")|| side2TextField.getText().equals("")|| side3TextField.getText().equals(""))
                triangleOutputTextField.setText("You have to enter the length of each of the 3 sides");
            else {
                try{
                    double side1 = Double.parseDouble(side1TextField.getText());
                    double side2 = Double.parseDouble(side2TextField.getText());
                    double side3 = Double.parseDouble(side3TextField.getText());
                    if (!(((side1 + side2) > side3) && ((side1 + side3) > side2) && ((side2 + side3) > side1))) {
                        triangleOutputTextField.setText("The area cannot be computed because the given lengths of sides do not form a valid triangle.");
                    } else {
                        shape = new Triangle("triangle", side1, side2, side3);
                        if (shape instanceof Triangle)
                            triangleOutputTextField.setText("The area of " + shape.toString() + " is " + ((Triangle) shape).area() + " square units.");
                        else
                            triangleOutputTextField.setText("No triangle has been instantiated");
                    }
                } catch(NumberFormatException x){
                    triangleOutputTextField.setText("Invalid input/s. Inputs must be in number format");
                }
            }
        });

        frameForTriangle.getContentPane().add(trianglePanel);
        frameForTriangle.pack();
        frameForTriangle.setVisible(true);
        frameForTriangle.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


    } // end showTriangleUI method

    /**
     * The user interface for obtaining the area of a square from the given length.
     * 1. It shows a label that prompts user to input the side, a text field to input length of side, a button to generate result, and
     *      a text field to display the area computed. Inputs must not be empty and are valid numbers.
     */
    private void showSquareUI(){
        frameForSquare = new JFrame("Area of a Square");

        JLabel inputLabel = new JLabel("Enter the length of the side of the square");

        JTextField sideTextField = new JTextField(20);

        JButton squareOutputButton = new JButton("Click to show area of the square");
        JTextField squareOutputTextField = new JTextField(60);
        squareOutputTextField.setEditable(false);

        JPanel squarePanel = new JPanel();
        squarePanel.setLayout(new GridLayout(2,2));

        squarePanel.add(inputLabel);
        squarePanel.add(sideTextField);
        squarePanel.add(squareOutputButton);
        squarePanel.add(squareOutputTextField);

        squareOutputButton.addActionListener((e)->{
            if (!sideTextField.getText().equals("")) {
                try{//Included a try catch statement to validate invalid character inputs -Raquel Bautista
                    double side = Double.parseDouble(sideTextField.getText());
                    shape = new Square("square", side);
                    if (shape instanceof  Square)
                        squareOutputTextField.setText("The area of " + shape.toString() + " is " + ((Square) shape).area() + " square units.");
                    else
                        squareOutputTextField.setText("No square has been instantiated");
                }catch (NumberFormatException x){
                    squareOutputTextField.setText("Invalid input. Input must be in number format.");
                }
            }
            else
                squareOutputTextField.setText("You have to enter the measurement of the side of the square.");
        });

        frameForSquare.getContentPane().add(squarePanel);
        frameForSquare.pack();
        frameForSquare.setVisible(true);
        frameForSquare.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }// end of showsSquareUI

    /**
     * The user interface for getting the area of a rectangle from the given length and width.
     * It includes a label for entering the length and width, a text field for the input, a button to show the area,
     * and a display text field. Inputs must not be empty and are valid numbers.
     */
    private void showRectangleUI(){

        frameForRectangle = new JFrame("Area of a Rectangle");

        JLabel inputLabel1 = new JLabel("Enter the length of the rectangle");
        JTextField lengthTextField = new JTextField(10);
        JLabel inputLabel2 = new JLabel("Enter the width of the rectangle");
        JTextField widthTextField = new JTextField(10);

        JButton rectangleOutputButton = new JButton("Click to show area of the rectangle");
        JTextField rectangleOutputTextField = new JTextField(60);
        rectangleOutputTextField.setEditable(false);

        JPanel rectanglePanel = new JPanel();
        rectanglePanel.setLayout(new GridLayout(3,2));

        rectanglePanel.add(inputLabel1);
        rectanglePanel.add(lengthTextField);
        rectanglePanel.add(inputLabel2);
        rectanglePanel.add(widthTextField);
        rectanglePanel.add(rectangleOutputButton);
        rectanglePanel.add(rectangleOutputTextField);

        rectangleOutputButton.addActionListener((e)->{
            try{
                if (lengthTextField.getText().equals("") || widthTextField.getText().equals(""))
                    rectangleOutputTextField.setText("You have to enter the length and width of the rectangle.");
                else {
                    double length = Double.parseDouble(lengthTextField.getText());
                    double width = Double.parseDouble(widthTextField.getText());
                    shape = new Rectangle("rectangle", length, width);
                    if (shape instanceof Rectangle)
                        rectangleOutputTextField.setText("The area of " + shape.toString() + " is " + ((Rectangle) shape).area() + " square units.");
                    else
                        rectangleOutputTextField.setText("No rectangle has been instantiated.");
                }
            }catch (NumberFormatException x){
                rectangleOutputTextField.setText("Invalid Input/s. Inputs must be in number format.");
            }


        });

        frameForRectangle.getContentPane().add(rectanglePanel);
        frameForRectangle.pack();
        frameForRectangle.setVisible(true);
        frameForRectangle.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    } //end of showRectangleUI

    /**
     * The user interface for the volume of a rectangular solid based from the given length, width, and height.
     * 1. User is prompted to input the values in the labels.
     * 2. User will then input the values in the given text fields beside each label.
     * 3. By clicking the button, the volume is generated and shown in the display text field.
     *      If the button is clicked
     *          if the input text fields are not empty and are valid numbers
     *              the length, width and height will be obtained from the text fields and parsed to double
     *              an object of shape RectangularSolid is then created
     *              if the shape is an instance of cylinder
     *                  show volume in the text field.
     */
    private void showRectangularSolidUI() {
        frameForRectangularSolid = new JFrame("Volume of a Rectangular Solid");
        JLabel inputLabel1 = new JLabel("Enter the length of the rectangular base of the rectangular solid");
        JLabel inputLabel2 = new JLabel("Enter the width of the rectangular base of the rectangular solid");
        JLabel inputLabel3 = new JLabel("Enter the height of the rectangular solid");

        JTextField inputTextFieldLength = new JTextField(10);
        JTextField inputTextFieldWidth = new JTextField(10);
        JTextField inputTextFieldHeight = new JTextField(10);
        JTextField rectangularSolidOutputTextField = new JTextField(60);
        rectangularSolidOutputTextField.setEditable(false);

        JButton resultButton = new JButton("Click to show volume of the rectangular solid");

        JPanel rectangularSolidPanel = new JPanel();
        rectangularSolidPanel.setLayout(new GridLayout(4,2));

        rectangularSolidPanel.add(inputLabel1);
        rectangularSolidPanel.add(inputTextFieldLength);
        rectangularSolidPanel.add(inputLabel2);
        rectangularSolidPanel.add(inputTextFieldWidth);
        rectangularSolidPanel.add(inputLabel3);
        rectangularSolidPanel.add(inputTextFieldHeight);
        rectangularSolidPanel.add(resultButton);
        rectangularSolidPanel.add(rectangularSolidOutputTextField);

        resultButton.addActionListener((e) ->{
            try{
                if (inputTextFieldLength.getText().equals("") || inputTextFieldWidth.getText().equals("") || inputTextFieldHeight.equals(""))
                    rectangularSolidOutputTextField.setText("You have to enter the length and width of the rectangle.");
                else {
                    double length = Double.parseDouble(inputTextFieldLength.getText());
                    double width = Double.parseDouble(inputTextFieldWidth.getText());
                    double height = Double.parseDouble(inputTextFieldHeight.getText());
                    shape = new RectangularSolid("rectangular solid", length, width,height);
                    if (shape instanceof RectangularSolid)
                        rectangularSolidOutputTextField.setText("The volume of " + shape.getName() + " is " + ((RectangularSolid) shape).volume() + " cubic units.");
                    else
                        rectangularSolidOutputTextField.setText("No rectangular solid has been instantiated.");
                }
            } catch (NumberFormatException x){
                rectangularSolidOutputTextField.setText("Invalid Input/s. Inputs must be in number format.");
            }
        });

        frameForRectangularSolid.getContentPane().add(rectangularSolidPanel);
        frameForRectangularSolid.pack();
        frameForRectangularSolid.setVisible(true);
        frameForRectangularSolid.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    } //end of showRectangularSolidUI

    /**
     * The user interface for getting the volume of a cylinder from the given radius, and height.
     * 1. User is prompted to input the radius and height through the labels.
     * 2. User will input the radius and height in the provided text fields beside the labels.
     * 3. The button will be clicked to generate volume
     *      If the button is clicked
     *          if the input text fields are not empty and are numeric values
     *              the radius and height will be parsed to double
     *              an object of shape cylinder will be created
     *              if the shape is an instance of cylinder
     *                  show volume of cylinder in the textfield.
     */
    private void showCylinderUI() {
        frameForCylinder = new JFrame("Volume of a Cylinder");
        JLabel inputLabel1 = new JLabel("Enter the radius of the circular base");
        JLabel inputLabel2 = new JLabel("Enter the height of the cylinder");

        JTextField inputTextField1Radius = new JTextField(10);
        JTextField inputTextField2Height = new JTextField(10);

        JTextField cylinderOutputTextField = new JTextField(60);
        cylinderOutputTextField.setEditable(false);

        JButton resultButton = new JButton("Click to show volume of the cylinder");

        JPanel cylinderPanel = new JPanel();
        cylinderPanel.setLayout(new GridLayout(3,2));

        cylinderPanel.add(inputLabel1);
        cylinderPanel.add(inputTextField1Radius);
        cylinderPanel.add(inputLabel2);
        cylinderPanel.add(inputTextField2Height);
        cylinderPanel.add(resultButton);
        cylinderPanel.add(cylinderOutputTextField);

        resultButton.addActionListener((e) ->{
            try{
                if (inputTextField1Radius.getText().equals("") || inputTextField2Height.getText().equals(""))
                    cylinderOutputTextField.setText("You have to enter the length and width of the rectangle.");
                else {
                    double radius = Double.parseDouble(inputTextField1Radius.getText());
                    double height = Double.parseDouble(inputTextField2Height.getText());
                    shape = new Cylinder("cylinder", radius, height);
                    if (shape instanceof Cylinder)
                        cylinderOutputTextField.setText("The volume of " + shape.toString() + " is " + ((Cylinder) shape).volume() + " cubic units.");
                    else
                        cylinderOutputTextField.setText("No rectangular solid has been instantiated.");
                }
            } catch (NumberFormatException x){
                cylinderOutputTextField.setText("Invalid Input/s. Inputs must be in number format.");
            }
        });
        frameForCylinder.getContentPane().add(cylinderPanel);
        frameForCylinder.pack();
        frameForCylinder.setVisible(true);
        frameForCylinder.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    } //end of showCylinderUI
} // end of class BautistaRaquelTester2

