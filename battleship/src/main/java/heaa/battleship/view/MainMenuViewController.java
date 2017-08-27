package heaa.battleship.view;

import heaa.battleship.model.GameSettings;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

/**
 * Luokka, joka kontrolloi pelin päävalikon mallintamista.
 *
 * @author heaarnio
 */
public class MainMenuViewController implements Runnable {

    private MainMenuView mainMenu;

    private final String TEN = "10";
    private final String TWENTY = "20";
    private final String THIRTY = "30";
    private final String FORTY = "40";

    private PositionView[][] grid;
    private ButtonGroup gridSizeSelection;

    public MainMenuViewController() {
        this.mainMenu = new MainMenuView();
    }

    @Override
    public void run() {
        mainMenu = new MainMenuView();
        gridSizeSelection = new ButtonGroup();
        mainMenu.setChooseGridSizeText();
        createSizeButtons();
        createStartButton();
        createExitButton();
        MainFrame.getInstance().setPanelInView(mainMenu.getMainPanel());
    }

    private void createSizeButtons() {
        JRadioButton ten = new JRadioButton(TEN);
        ten.setActionCommand(TEN);
        ten.setSelected(true);
        JRadioButton twenty = new JRadioButton(TWENTY);
        twenty.setActionCommand(THIRTY);
        JRadioButton thirty = new JRadioButton(THIRTY);
        thirty.setActionCommand(THIRTY);
        JRadioButton forty = new JRadioButton(FORTY);
        forty.setActionCommand(FORTY);
        gridSizeSelection.add(ten);
        gridSizeSelection.add(twenty);
        gridSizeSelection.add(thirty);
        gridSizeSelection.add(forty);
        this.mainMenu.setGridSizeRadioButtons(ten, twenty, thirty, forty);
    }

    private void createStartButton() {
        JButton start = new JButton("Start game");
        start.addActionListener(action -> {
            Integer size = new Integer(gridSizeSelection.getSelection().getActionCommand());
            GameSettings.getInstance().setGridSize(size);
            SwingUtilities.invokeLater(new ShipDeploymentViewController());
        });
        this.mainMenu.setStartButton(start);
    }

    private void createExitButton() {
        JButton exit = new JButton("Exit");
        exit.addActionListener(action -> {
            System.exit(0);
        });
        this.mainMenu.setExitButton(exit);
    }

}
