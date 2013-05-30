/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb138.evidenceskladurestaurace;

import cz.muni.fi.pb138.evidenceskladurestaurace.persistence.Ingredient;
import cz.muni.fi.pb138.evidenceskladurestaurace.persistence.IngredientDAO;
import cz.muni.fi.pb138.evidenceskladurestaurace.persistence.Unit;
import cz.muni.fi.pb138.evidenceskladurestaurace.model.IngredientsTableModel;
import cz.muni.fi.pb138.evidenceskladurestaurace.persistence.Recipe;
import cz.muni.fi.pb138.evidenceskladurestaurace.persistence.RecipeDAO;
import cz.muni.fi.pb138.evidenceskladurestaurace.persistence.RecipeDAOImpl;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author fbogyai
 */
public class IngredientDialog extends javax.swing.JFrame {

    private Ingredient ingredient;
    private IngredientDAO ingredientDAO;
    private IngredientsTableModel ingredientsTableModel;
    private List<Ingredient> recipeIngredientList = new ArrayList<>();
    private RecipeDAO recipeDAO = new RecipeDAOImpl();
    private Recipe receipt = null;
    private Boolean createNew = true;
    private Boolean recipeEdit = false;

    /**
     * Creates new form IngredientDialog
     */
    public IngredientDialog(IngredientsTableModel ingredientsTableModel, IngredientDAO ingredientDAO) {
        initComponents();
        this.ingredientsTableModel = ingredientsTableModel;
        this.ingredientDAO = ingredientDAO;
        setLocationRelativeTo(null);
        ingredient = new Ingredient();
    }

    public IngredientDialog(IngredientsTableModel ingredientsTableModel, IngredientDAO ingredientDAO, Ingredient ingredient) {
        initComponents();
        this.ingredient = ingredient;
        this.ingredientsTableModel = ingredientsTableModel;
        this.ingredientDAO = ingredientDAO;
        setLocationRelativeTo(null);

        createNew = false;
        nameField.setText(ingredient.getName());
        unitBox.setSelectedItem(ingredient.getUnit());
        ammountSpinner.setValue(ingredient.getAmount());
        createButton.setText("Save");
        ingredientLabel.setText("Edit Ingredient");

    }

    public IngredientDialog(IngredientsTableModel ingredientsTableModel, IngredientDAO ingredientDAO, Ingredient ingredient,RecipeDAO recipeDAO, Recipe receipt) {
        initComponents();
        this.ingredient = ingredient;
        this.ingredientsTableModel = ingredientsTableModel;
        this.ingredientDAO = ingredientDAO;
        this.receipt = receipt;
        this.recipeDAO = recipeDAO;

        this.recipeIngredientList = receipt.getIngredients();

        setLocationRelativeTo(null);

        recipeEdit = true;
        nameField.setText(ingredient.getName());
        nameField.setEditable(false);
        unitBox.setSelectedItem(ingredient.getUnit());
        ammountSpinner.setValue(ingredient.getAmount());
        createButton.setText("Save");
        ingredientLabel.setText("Edit Ingredient");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameField = new javax.swing.JTextField();
        ingredientLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        unitBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        ammountSpinner = new javax.swing.JSpinner();
        createButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ingredientLabel.setText("Create new Ingredient");

        jLabel2.setText("Name :");

        jLabel3.setText("Unit :");

        unitBox.setModel(new DefaultComboBoxModel(Unit.values()));
        unitBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitBoxActionPerformed(evt);
            }
        });

        jLabel4.setText("Ammount :");

        ammountSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        createButton.setText("Create");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cancelButton)
                                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(unitBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ammountSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ingredientLabel)
                            .addComponent(createButton))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ingredientLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(unitBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ammountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void unitBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unitBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unitBoxActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        ingredient.setName(nameField.getText());
        ingredient.setUnit((Unit) unitBox.getSelectedItem());
        ingredient.setAmount((int) ammountSpinner.getValue());

        if (recipeEdit) {
            ingredientsTableModel.setIngredients(recipeIngredientList);

        } else {

            if (createNew) {
                ingredientDAO.create(ingredient);
            } else {
                ingredientDAO.update(ingredient);
            }

            ingredientsTableModel.setIngredients(ingredientDAO.findAll());
        }

        dispose();
    }//GEN-LAST:event_createButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner ammountSpinner;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton createButton;
    private javax.swing.JLabel ingredientLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField nameField;
    private javax.swing.JComboBox unitBox;
    // End of variables declaration//GEN-END:variables
}
