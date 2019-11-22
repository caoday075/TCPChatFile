/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import models.ItemDAO;
import models.ItemDTO;
import models.SupplierDAO;
import models.SupplierDTO;
import validator.CommonValidator;

/**
 *
 * @author SE130531
 */
public class ManagerItems extends javax.swing.JFrame {

    DefaultTableModel tblModelSupplier = null;
    DefaultTableModel tblModelItem = null;

    boolean addNewSupp = false;
    boolean addNewItem = false;

    int data_totalSupp;
    int page_sizeSupp = 2;
    int page_noSupp;
    int page_totalSupp;

    int data_totalItem;
    int page_sizeItem = 5;
    int page_noItem;
    int page_totalItem;

    SupplierDAO supDAO = new SupplierDAO();
    List<SupplierDTO> listSupp = new ArrayList<>();
    ItemDAO itemDAO = new ItemDAO();
    List<ItemDTO> listItem = new ArrayList<>();

    Border errorBorder = BorderFactory.createLineBorder(Color.red, 1);
    Border defaultBorder;

    public ManagerItems() {;
        initComponents();
        tblModelSupplier = (DefaultTableModel) tblSupplier.getModel();
        tblModelItem = (DefaultTableModel) tblItem.getModel();
        loadSupp(0);
        loadItem(0);
    }

    /*
    public void loadSupp() {
        try {
            SupplierDAO supDAO = new SupplierDAO();
            List<SupplierDTO> list = supDAO.getAllSupp();
            tblModelSupplier.setRowCount(0);

            for (SupplierDTO supplierDTO : list) {
                tblModelSupplier.addRow(supplierDTO.toVector());
            }

        } catch (Exception e) {
            Logger.getLogger(ManagerItems.class.getName()).log(Level.SEVERE, null, e);
        }

    }
     */
    public void loadSupp(int page_noSupp) {
        if (page_noSupp == -1) {
            return;
        }
        cbPageNoSupp.removeAllItems();
        try {
            listSupp.clear();
            listSupp = supDAO.getAllSupp();
            tblModelSupplier.setRowCount(0);

            data_totalSupp = listSupp.size();
            page_totalSupp = (int) Math.ceil(data_totalSupp / (double) page_sizeSupp);
            for (int i = 0; i < page_totalSupp; i++) {
                cbPageNoSupp.addItem(String.valueOf(i + 1));
            }
            int start_index = page_noSupp * page_sizeSupp;
            int stop_index = start_index + 2;
            stop_index = Math.min(stop_index, data_totalSupp);

            for (int i = start_index; i < stop_index; i++) {
                tblModelSupplier.addRow(listSupp.get(i).toVector());
                tblModelItem.setRowCount(5);
            }
            cbPageNoSupp.setSelectedIndex(page_noSupp);
            tblSupplier.updateUI();

        } catch (Exception e) {
            Logger.getLogger(ManagerItems.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void loadItem(int page_noItem) {
        if (page_noItem == -1) {
            return;
        }
        try {
            listItem.clear();
            listItem = itemDAO.getAllItem();
            load_CbSupp();

            tblModelItem.setRowCount(0);

            data_totalItem = listItem.size();
            page_totalItem = (int) Math.ceil(data_totalItem / (double) page_sizeItem);
            cbPageNoItem.removeAllItems();
            for (int i = 0; i < page_totalItem; i++) {
                cbPageNoItem.addItem(String.valueOf(i + 1));
            }
            int start_index = page_noItem * page_sizeItem;
            int stop_index = start_index + 5;
            stop_index = Math.min(stop_index, data_totalItem);

            for (int i = start_index; i < stop_index; i++) {
                tblModelItem.addRow(listItem.get(i).toVector());
            }

            cbPageNoItem.setSelectedIndex(page_noItem);
            tblItem.updateUI();

        } catch (Exception e) {
            Logger.getLogger(ManagerItems.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void load_CbSupp() {
        cbSupp.removeAllItems();
        for (SupplierDTO supplierDTO : listSupp) {
            cbSupp.addItem(supplierDTO.toString());
        }
    }

    public ArrayList<Integer> getIndexSuppCodeItem(String code) {
        ArrayList<Integer> listIndex = new ArrayList();
        for (int i = 0; i < listItem.size(); i++) {
            if (listItem.get(i).getSupCode().equalsIgnoreCase(code)) {
                listIndex.add(i);
            }
        }
        return listIndex;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSupplier = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtSuppCode = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtSuppName = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtSuppAddress = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        chbCollo = new javax.swing.JCheckBox();
        btnSuppNew = new javax.swing.JButton();
        btnSuppSave = new javax.swing.JButton();
        btnSuppRemove = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        cbPageNoSupp = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblItem = new javax.swing.JTable();
        cbPageNoItem = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtItemCode = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtItemName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbSupp = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtItemUnit = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtItemPrice = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        chbSupplying = new javax.swing.JCheckBox();
        btnItemNew = new javax.swing.JButton();
        btnItemSave = new javax.swing.JButton();
        btnItemRemove = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtSearchItem = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 204));
        jLabel9.setText("Supplier List");

        tblSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "SupCode", "SupName", "Adress", "colloborating"
            }
        ));
        tblSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSupplierMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSupplier);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Supplier Details"));

        jLabel10.setText("Supplier Code:");

        jLabel11.setText("Supplier Name:");

        jLabel12.setText("Address:");

        jLabel13.setText("Collorborating:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(txtSuppCode, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSuppName)
                            .addComponent(txtSuppAddress)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chbCollo)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtSuppCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtSuppName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSuppAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(chbCollo))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        btnSuppNew.setText("Add New ");
        btnSuppNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuppNewActionPerformed(evt);
            }
        });

        btnSuppSave.setText("Save");
        btnSuppSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuppSaveActionPerformed(evt);
            }
        });

        btnSuppRemove.setText("Remove");
        btnSuppRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuppRemoveActionPerformed(evt);
            }
        });

        jLabel14.setText("Page:");

        cbPageNoSupp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbPageNoSupp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPageNoSuppActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(cbPageNoSupp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSuppNew, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSuppSave, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSuppRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSuppNew)
                            .addComponent(btnSuppSave)
                            .addComponent(btnSuppRemove)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbPageNoSupp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manager Suppliers", jPanel1);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Items List");

        tblItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "itemCode", "itemName", "suppCode", "unit", "price", "supplying"
            }
        ));
        tblItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblItemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblItem);

        cbPageNoItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbPageNoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPageNoItemActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Item Details"));

        jLabel2.setText("Item Code: ");

        jLabel3.setText("Item Name: ");

        jLabel4.setText("Supplier:");

        cbSupp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbSupp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSuppActionPerformed(evt);
            }
        });

        jLabel5.setText("Unit:");

        jLabel6.setText("Price:");

        jLabel7.setText("Supplying: ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtItemPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(chbSupplying))
                    .addComponent(txtItemName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSupp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtItemUnit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtItemCode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtItemCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtItemName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cbSupp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtItemUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtItemPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chbSupplying)
                    .addComponent(jLabel7))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        btnItemNew.setText("Add New");
        btnItemNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemNewActionPerformed(evt);
            }
        });

        btnItemSave.setText("Save ");
        btnItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemSaveActionPerformed(evt);
            }
        });

        btnItemRemove.setText("Remove");
        btnItemRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemRemoveActionPerformed(evt);
            }
        });

        jLabel8.setText("Page:");
        jLabel8.setToolTipText("");

        txtSearchItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchItemActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearchItem, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbPageNoItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnItemNew)
                        .addGap(37, 37, 37)
                        .addComponent(btnItemSave, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnItemRemove))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(cbPageNoItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSearchItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSearch)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnItemNew)
                            .addComponent(btnItemSave)
                            .addComponent(btnItemRemove))))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manager Items", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Manager Suppliers");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSupplierMouseClicked
        int selectedRow = tblSupplier.getSelectedRow();
        String supCode = tblSupplier.getValueAt(selectedRow, 0).toString();
        String supName = tblSupplier.getValueAt(selectedRow, 1).toString();
        String address = tblSupplier.getValueAt(selectedRow, 2).toString();
        boolean check = Boolean.parseBoolean(tblSupplier.getValueAt(selectedRow, 3).toString());

        txtSuppCode.setText(supCode);
        txtSuppCode.setEditable(false);
        txtSuppName.setText(supName);
        txtSuppAddress.setText(address);
        chbCollo.setSelected(check);
        addNewSupp = false;
    }//GEN-LAST:event_tblSupplierMouseClicked

    private void cbPageNoSuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPageNoSuppActionPerformed
        page_noSupp = cbPageNoSupp.getSelectedIndex();
        loadSupp(page_noSupp);
        tblSupplier.getSelectionModel().clearSelection();
    }//GEN-LAST:event_cbPageNoSuppActionPerformed

    private void cbPageNoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPageNoItemActionPerformed
        page_noItem = cbPageNoItem.getSelectedIndex();
        loadItem(page_noItem);
        tblItem.getSelectionModel().clearSelection();
    }//GEN-LAST:event_cbPageNoItemActionPerformed

    private void tblItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblItemMouseClicked
        int selectedRow = tblItem.getSelectedRow();
        String itemCode = tblItem.getValueAt(selectedRow, 0).toString();
        String itemName = tblItem.getValueAt(selectedRow, 1).toString();
        String suppCode = tblItem.getValueAt(selectedRow, 2).toString();
        SupplierDTO suppDTO = listSupp.get(0);
        for (int i = 1; i < listSupp.size(); i++) {
            if (listSupp.get(i).getSupCode().equalsIgnoreCase(suppCode)) {
                suppDTO = listSupp.get(i);
            }
        }
        String unit = tblItem.getValueAt(selectedRow, 3).toString();
        String price = tblItem.getValueAt(selectedRow, 4).toString();
        boolean check = Boolean.parseBoolean(tblItem.getValueAt(selectedRow, 5).toString());

        txtItemCode.setText(itemCode);
        txtItemCode.setEditable(false);
        txtItemName.setText(itemName);
        cbSupp.setSelectedItem(suppDTO.toString());

        txtItemUnit.setText(unit);
        txtItemPrice.setText(price);
        chbSupplying.setSelected(check);
        addNewItem = false;
    }//GEN-LAST:event_tblItemMouseClicked

    private void cbSuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSuppActionPerformed

    }//GEN-LAST:event_cbSuppActionPerformed

    private void btnSuppNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuppNewActionPerformed
        addNewSupp = true;
        txtSuppCode.setEditable(true);
        txtSuppCode.setText("");
        txtSuppName.setText("");
        txtSuppAddress.setText("");
        chbCollo.setSelected(false);
    }//GEN-LAST:event_btnSuppNewActionPerformed

    private void btnSuppSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuppSaveActionPerformed
        String code = txtSuppCode.getText();
        if (!CommonValidator.checkSupCode(code)) {
            JOptionPane.showMessageDialog(this, "Invalid Supplier Code [A_Z]{,5}");
            txtSuppCode.requestFocus();
            txtSuppCode.setBorder(errorBorder);
            return;
        } else {
            try {
                boolean flag = supDAO.isCodeDuplicate(code, "Suppliers", "supCode");
                if (flag) {
                    JOptionPane.showMessageDialog(this, "Code is dulicated!");
                    txtSuppCode.requestFocus();
                    txtSuppCode.setBorder(errorBorder);
                    return;
                } else {
                    txtSuppCode.setBorder(defaultBorder);
                }
            } catch (Exception e) {
            }
        }

        String name = txtSuppName.getText();
        if (!CommonValidator.checkName(name)) {
            JOptionPane.showMessageDialog(this, "Invalid Name [.{5,30}]");
            txtSuppName.requestFocus();
            txtSuppName.setBorder(errorBorder);
            return;
        } else {
            txtSuppName.setBorder(defaultBorder);
        }

        String address = txtSuppAddress.getText();
        if (!CommonValidator.checkName(address)) {
            JOptionPane.showMessageDialog(this, "Invalid Address [.{5,30}]");
            txtSuppAddress.requestFocus();
            txtSuppAddress.setBorder(errorBorder);
            return;
        } else {
            txtSuppAddress.setBorder(defaultBorder);
        }

        boolean collo = chbCollo.isSelected();
        SupplierDAO suppDAO = new SupplierDAO();
        if (addNewSupp) {
            try {
                boolean flag = suppDAO.addNewSupplier(code, name, address, collo);
                if (flag) {
                    JOptionPane.showMessageDialog(this, "Add new Supplier success!");
                    addNewSupp = false;
                } else {
                    JOptionPane.showMessageDialog(this, "Add supplier failed!");
                }
            } catch (Exception e) {
                Logger.getLogger(ManagerItems.class.getName()).log(Level.SEVERE, null, e);
            }
        } else {
            try {
                if (tblSupplier.getSelectedRow() < 0) {
                    return;
                }
                boolean flag = suppDAO.updateSupplier(code, name, address, collo);
                if (flag) {
                    JOptionPane.showMessageDialog(this, "Update Supplier success!");
                } else {
                    JOptionPane.showMessageDialog(this, "Update Supplier failed!");
                }

            } catch (Exception e) {
                Logger.getLogger(ManagerItems.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        loadSupp(page_noSupp);
        tblSupplier.updateUI();
    }//GEN-LAST:event_btnSuppSaveActionPerformed

    private void btnSuppRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuppRemoveActionPerformed
        int selectedRow = tblSupplier.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a record to remove");
        }

        String supCode = txtSuppCode.getText();

        ArrayList<Integer> listSupCodeInItem = getIndexSuppCodeItem(supCode);

        if (listSupCodeInItem.isEmpty()) {
            if (JOptionPane.showConfirmDialog(this, "Remove this data??",
                    "Remove", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                try {
                    String code = tblSupplier.getValueAt(selectedRow, 0).toString();
                    boolean flag = supDAO.deleteSupplier(code);
                    if (flag) {
                        JOptionPane.showMessageDialog(this, "Remove Supplier Success");
                        loadSupp(page_noSupp);
                        load_CbSupp();
                        tblSupplier.updateUI();
                    }
                } catch (Exception e) {
                    Logger.getLogger(ManagerItems.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        } else {
            if (JOptionPane.showConfirmDialog(this, "This recored are suing in other item. Are you sure to delete???",
                    "Delete", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                try {
                    for (int i = 0; i < listSupCodeInItem.size(); i++) {
                        String itemCode = listItem.get(listSupCodeInItem.get(i)).getItemCode();
                        System.out.println(listItem.get(listSupCodeInItem.get(1)).getItemCode());
                        boolean flag = itemDAO.deleteItem(itemCode);
                        if (flag) {
                        }
                    }
                    loadItem(page_noItem);
                    load_CbSupp();
                    tblItem.updateUI();
                } catch (Exception e) {
                    Logger.getLogger(ManagerItems.class.getName()).log(Level.SEVERE, null, e);
                }

                try {
                    boolean flag = supDAO.deleteSupplier(supCode);
                    if (flag) {
                        JOptionPane.showMessageDialog(this, "Delete successs!");
                        loadSupp(page_noSupp);
                        load_CbSupp();
                        tblSupplier.updateUI();
                    }
                } catch (Exception e) {
                    Logger.getLogger(ManagerItems.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }//GEN-LAST:event_btnSuppRemoveActionPerformed

    private void btnItemNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemNewActionPerformed
        addNewItem = true;
        txtItemCode.setEditable(true);
        txtItemCode.setText("");
        txtItemName.setText("");
        txtItemPrice.setText("");
        txtItemUnit.setText("");
        chbSupplying.setSelected(false);
    }//GEN-LAST:event_btnItemNewActionPerformed

    private void btnItemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemSaveActionPerformed
        String code = txtItemCode.getText();
        if (!CommonValidator.checkItemCode(code)) {
            JOptionPane.showMessageDialog(this, "Invalid Item Code [E****]");
            txtItemCode.requestFocus();
            txtItemCode.setBorder(errorBorder);
            return;
        } else {
            try {
                boolean flag = supDAO.isCodeDuplicate(code, "Items", "itemCode");
                if (flag) {
                    JOptionPane.showMessageDialog(this, "Code is dulicated!");
                    txtItemCode.requestFocus();
                    txtItemCode.setBorder(errorBorder);
                    return;
                } else {
                    txtItemCode.setBorder(defaultBorder);
                }                
            } catch (Exception e) {
            }
            
            txtItemCode.setBorder(defaultBorder);
        }

        String name = txtItemName.getText();
        if (!CommonValidator.checkItemName(name)) {
            JOptionPane.showMessageDialog(this, "Invalid Item Name [.{3,50}]");
            txtItemName.requestFocus();
            txtItemName.setBorder(errorBorder);
            return;
        } else {
            txtItemName.setBorder(defaultBorder);
        }

        int index = cbSupp.getSelectedIndex();
        String toString = cbSupp.getItemAt(index);
        String supCode = toString.substring(0, toString.indexOf("-"));

        String unit = txtItemUnit.getText();
        if (!CommonValidator.checkItemUnit(unit)) {
            JOptionPane.showMessageDialog(this, "Invalid Item Unit [.{3,30}]");
            txtItemUnit.requestFocus();
            txtItemUnit.setBorder(errorBorder);
            return;
        } else {
            txtItemUnit.setBorder(defaultBorder);
        }

        String priceTmp = txtItemPrice.getText();
        int price = 0;
        try {
            price = Integer.parseInt(priceTmp);
            if (price <= 0) {
                throw new Exception();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid price > 0");
            txtItemPrice.requestFocus();
            txtItemPrice.setBorder(errorBorder);
            return;
        }
        txtItemPrice.setBorder(defaultBorder);
        boolean supplying = chbSupplying.isSelected();

        if (addNewItem) {
            try {
                boolean flag = itemDAO.addNewItem(code, name, supCode, unit, price, supplying);
                if (flag) {
                    JOptionPane.showMessageDialog(this, "Add new Item success!");
                } else {
                    JOptionPane.showMessageDialog(this, "Add new Item failed!!");
                }
            } catch (Exception e) {
                Logger.getLogger(ManagerItems.class.getName()).log(Level.SEVERE, null, e);
            }
        } else {
            if (tblItem.getSelectedRow() < 0) {
                return;
            }
            try {
                boolean flag = itemDAO.updateItem(code, name, supCode, unit, price, supplying);
                if (flag) {
                    JOptionPane.showMessageDialog(this, "Update Item success!");
                } else {
                    JOptionPane.showMessageDialog(this, "Update new Item failed!");
                }
            } catch (Exception e) {
                Logger.getLogger(ManagerItems.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        loadItem(page_noItem);
        tblItem.updateUI();
    }//GEN-LAST:event_btnItemSaveActionPerformed

    private void btnItemRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemRemoveActionPerformed
        int selectedRow = tblItem.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an record to remove!!");
            return;
        }
        if (JOptionPane.showConfirmDialog(this, "Remove this data??",
                "Remove", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                String code = tblItem.getValueAt(selectedRow, 0).toString();
                boolean flag = itemDAO.deleteItem(code);
                if (flag) {
                    JOptionPane.showMessageDialog(this, "Delete succesfully!");
                    loadItem(page_noItem);
                    load_CbSupp();
                    tblItem.updateUI();
                }
            } catch (Exception e) {
                Logger.getLogger(ManagerItems.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }//GEN-LAST:event_btnItemRemoveActionPerformed

    private void txtSearchItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchItemActionPerformed

    }//GEN-LAST:event_txtSearchItemActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String str = txtSearchItem.getText().trim().toUpperCase();
        boolean flag = false; //false
        Vector<ItemDTO> tmp = new Vector();
        for (int i = 0; i < listItem.size(); i++) {
            if (listItem.get(i).getItemName().toUpperCase().contains(str)) {
                flag = true;
                tmp.add(listItem.get(i));
            }
        }
        if (flag) {
            Object[] cols = {
                "ItemCode", "Name", "SupCode", "Unit", "Price", "Supplying"
            };
            String[][] rows = new String[100][6];
            for (int i = 0; i < tmp.size(); i++) {
                rows[i][0] = tmp.get(i).getItemCode();
                rows[i][1] = tmp.get(i).getItemName();
                rows[i][2] = tmp.get(i).getSupCode();
                rows[i][3] = tmp.get(i).getUnit();
                rows[i][4] = String.valueOf(tmp.get(i).getPrice());
                rows[i][5] = String.valueOf(tmp.get(i).isSupplying());
            }
            JTable table = new JTable(rows, cols);
            JOptionPane.showMessageDialog(null, new JScrollPane(table));
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManagerItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ManagerItems mmg = new ManagerItems();
                mmg.setLocationRelativeTo(null);
                mmg.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnItemNew;
    private javax.swing.JButton btnItemRemove;
    private javax.swing.JButton btnItemSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSuppNew;
    private javax.swing.JButton btnSuppRemove;
    private javax.swing.JButton btnSuppSave;
    private javax.swing.JComboBox<String> cbPageNoItem;
    private javax.swing.JComboBox<String> cbPageNoSupp;
    private javax.swing.JComboBox<String> cbSupp;
    private javax.swing.JCheckBox chbCollo;
    private javax.swing.JCheckBox chbSupplying;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblItem;
    private javax.swing.JTable tblSupplier;
    private javax.swing.JTextField txtItemCode;
    private javax.swing.JTextField txtItemName;
    private javax.swing.JTextField txtItemPrice;
    private javax.swing.JTextField txtItemUnit;
    private javax.swing.JTextField txtSearchItem;
    private javax.swing.JTextField txtSuppAddress;
    private javax.swing.JTextField txtSuppCode;
    private javax.swing.JTextField txtSuppName;
    // End of variables declaration//GEN-END:variables
}
