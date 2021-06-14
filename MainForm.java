/**
 * 1972003 Ilman Nawali
 */

package com.ilman.view;

import com.ilman.entity.Category;
import com.ilman.entity.Item;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainForm {
    private JTextField idField;
    private JTextField namaField;
    private JTextField priceField;
    private JComboBox<Category> comboBox1;
    private JButton save;
    private JButton Reset;
    private JButton Update;
    private JSplitPane rootPanel1;
    private JPanel rootPanel;
    private JTable table1;
    private Item selectedItem;
    private int selectedIndex;

    public MainForm(){
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1,"Food",2000));
        categories.add(new Category(2,"Beverage",2000));


        DefaultComboBoxModel<Category> categoryComboModel =
                new DefaultComboBoxModel<>(categories.toArray(new Category[0]));
        comboBox1.setModel(categoryComboModel);

        List<Item> items = new ArrayList<>();


        ItemTableModel itemTableModel = new ItemTableModel(items);
        table1.setModel(itemTableModel);
        table1.setAutoCreateRowSorter(true);
        save.addActionListener(e -> {
            if (idField.getText().isEmpty()||namaField.getText().isEmpty()||priceField.getText().isEmpty()){
                JOptionPane.showMessageDialog(rootPanel,"Please fill in all field","Error",JOptionPane.ERROR_MESSAGE);
            }
            else {
                Item item = new Item();
                item.setId(Integer.parseInt(idField.getText()));
                item.setName(namaField.getText());
                item.setPrice(Integer.parseInt(priceField.getText()));
                item.setCategory((Category) comboBox1.getSelectedItem());
                items.add(item);
                itemTableModel.fireTableDataChanged();
                clearAndReset();
            }
        });

        Reset.addActionListener(e -> {
            clearAndReset();
        });
        Update.addActionListener(e -> {
            if (idField.getText().isEmpty()||namaField.getText().isEmpty()||priceField.getText().isEmpty()){
                JOptionPane.showMessageDialog(rootPanel,"Please fill in all field","Error",JOptionPane.ERROR_MESSAGE);
            }
            else {
                selectedItem.setId(Integer.parseInt(idField.getText()));
                selectedItem.setName(namaField.getText());
                selectedItem.setPrice(Integer.parseInt(priceField.getText()));
                selectedItem.setCategory((Category) comboBox1.getSelectedItem());
                items.set(selectedIndex, selectedItem);
                itemTableModel.fireTableDataChanged();
                clearAndReset();
            }
        });
        table1.getSelectionModel().addListSelectionListener(e1 -> {
            if (!table1.getSelectionModel().isSelectionEmpty()){
                selectedIndex=table1.convertRowIndexToModel(table1.getSelectedRow());
                selectedItem= items.get(selectedIndex);
                if (selectedItem != null) {
                    namaField.setText(selectedItem.getName());
                    priceField.setText(String.valueOf(selectedItem.getPrice()));
                    comboBox1.setSelectedItem(selectedItem.getCategory());
                    save.setEnabled(false);
                    Update.setEnabled(true);
                }

            }
        });
    }

    private void clearAndReset(){
        idField.setText("");
        namaField.setText("");
        priceField.setText("");
        table1.clearSelection();
        save.setEnabled(true);
        Update.setEnabled(false);
        selectedItem = null;
        selectedIndex = 1;
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("PB02 M10");
        frame.setContentPane(new MainForm().rootPanel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

    private static class ItemTableModel extends AbstractTableModel {

        private final String[] COLUMS = {"ID","NAME","PRICE","CATEGORY"};
        private List<Item> items;

        public ItemTableModel(List<Item> items) {
            this.items = items;
        }

        @Override
        public int getRowCount() {
            return items.size();
        }

        @Override
        public int getColumnCount() {
            return COLUMS.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return switch (columnIndex) {
                case 0 -> items.get(rowIndex).getId();
                case 1 -> items.get(rowIndex).getName();
                case 2 -> items.get(rowIndex).getPrice();
                case 3 -> items.get(rowIndex).getCategory();
                default -> "-";
            };
        }
        @Override
        public String getColumnName(int column) {
            return COLUMS[column];

        }
        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (getValueAt(0,columnIndex) != null){
                return getValueAt(0,columnIndex).getClass();
            }else{
                return Object.class;
            }
        }


    }
}
