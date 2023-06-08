package Jframe;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;


/**
 *
 * @author thali
 */
public class LoanBooks extends javax.swing.JFrame {

    /**
     * Creates new form LoanBooks
     */
    public LoanBooks() {
        initComponents();
    }

    public void getBookDetails() throws Exception{
        int bookId = Integer.parseInt(txtBid.getText());
        String query = "SELECT * FROM `book_details` WHERE `book_id` =?";
        try {
            
            PreparedStatement ps = DBConnection.getcon().prepareStatement(query);
            ps.setInt(1, bookId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                
                lblBookId.setText(rs.getString("book_id"));
                
                lblBookName.setText(rs.getString("book_name"));
                lblBookAuther.setText(rs.getString("author_name"));
                lblBookQuantity.setText(rs.getString("quantity"));
            }else{
                sID.setText("");
                
                Sname.setText("");
                Scourse.setText("");
                sbranch.setText("");
                validB.setText("invalid Book ID");
            }
        } catch (ClassNotFoundException | SQLException e) {
        }
    }
    
     public void getStudentDetails() throws Exception{
        int stId = Integer.parseInt(txtSid.getText());
        String query = "SELECT * FROM `student_details` WHERE `id` =?";
        try {
            
            PreparedStatement ps = DBConnection.getcon().prepareStatement(query);
            ps.setInt(1, stId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                
                sID.setText(rs.getString("id"));
                
                Sname.setText(rs.getString("student_name"));
                Scourse.setText(rs.getString("course"));
                sbranch.setText(rs.getString("branch"));
            }else{
                sID.setText("");
                
                Sname.setText("");
                Scourse.setText("");
                sbranch.setText("");
                
                validS.setText("invalid Student ID");
            
            }
        } catch (ClassNotFoundException | SQLException e) {
        }
    }
     
     public boolean loanBook(){
         boolean islaoned = false;
         int bookId = Integer.parseInt(txtBid.getText());
         int stId = Integer.parseInt(txtSid.getText());
         String bookName = lblBookName.getText();
         String studentName = Sname.getText();
         Date Uloanedate = dataLoan.getDatoFecha();
         Date Uduedate = dataDue.getDatoFecha();
         
         Long l1 = Uloanedate.getTime();
         Long l2 = Uduedate.getTime();
         
         java.sql.Date Sloandate = new java.sql.Date(l1);
         java.sql.Date Sduedate = new java.sql.Date(l2);
         
         try {
//              DBConnection.insertData("insert into loan_books(bookid,bookName,student_id,student_name,loan_date,due_date,status)"
//                  +"Values('"+ bookId+"','"+ bookName+"','"+ stId+"','"+ studentName+"','"+Sloandate+"','"+Sduedate+"',"+st+"'')" );
                Connection con = DBConnection.getcon();
                String sql = "insert into `loan_books`(bookid,bookName,student_id,student_name,loan_date,due_date,status) Values(?,?,?,?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setInt(1, bookId);
                pst.setString(2, bookName);
                pst.setInt(3, stId);
                pst.setString(4, studentName);
                pst.setDate(5, Sloandate);
                pst.setDate(6, Sduedate);
                pst.setString(7, "pending");
                
                int rowCount = pst.executeUpdate();
                if (rowCount > 0){
                    islaoned = true;
                }
                else{
                    islaoned = false;
                }
                
             

         } catch (Exception e) {
             e.printStackTrace();
         }
        return islaoned;
         
     }
     
     public void updateBook() throws Exception{
            int bookId = Integer.parseInt(txtBid.getText());
            Connection con = DBConnection.getcon();
            String sql = "update `book_details` set quantity = quantity - 1 where book_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            int rowCount = pst.executeUpdate();
            if (rowCount > 0){
                int inCount = Integer.parseInt(lblBookQuantity.getText());
                lblBookQuantity.setText(Integer.toString(inCount - 1));
           }
            else{
                JOptionPane.showMessageDialog(this, "can't update the book quality");
            }
         
     }
     public boolean isAlreadyLoaned(){
         boolean isloaned = false;
         int bookId = Integer.parseInt(txtBid.getText());
         int stId = Integer.parseInt(txtSid.getText());
        try {
            Connection con = DBConnection.getcon();
            String sql = "select * from `loan_books` where bookid = ? and student_id = ? and status = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setInt(2, stId);
            pst.setString(3, "pending");
             ResultSet rowCount = pst.executeQuery();
            if (rowCount.next()){
                isloaned= true;
            }
            else{
                isloaned = false;
            }
        } catch (Exception ex) {
            Logger.getLogger(LoanBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isloaned;
        
     }
   
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBookID = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblBookId = new javax.swing.JLabel();
        lblBookName = new javax.swing.JLabel();
        lblBookQuantity = new javax.swing.JLabel();
        lblBookAuther = new javax.swing.JLabel();
        sbranch = new javax.swing.JLabel();
        sID = new javax.swing.JLabel();
        Sname = new javax.swing.JLabel();
        Scourse = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        validB = new javax.swing.JLabel();
        validS = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtBid = new rojerusan.RSMetroTextPlaceHolder();
        txtSid = new rojerusan.RSMetroTextPlaceHolder();
        dataLoan = new rojeru_san.componentes.RSDateChooser();
        dataDue = new rojeru_san.componentes.RSDateChooser();
        rSMaterialButtonCircle1 = new necesario.RSMaterialButtonCircle();
        jLabel26 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBookID.setBackground(new java.awt.Color(0, 0, 204));
        lblBookID.setForeground(new java.awt.Color(255, 255, 255));
        lblBookID.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblBookID.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 204, 51));
        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Book_50px_1.png"))); // NOI18N
        jLabel3.setText("book details");
        jLabel3.setToolTipText("");
        jLabel3.setName(""); // NOI18N
        lblBookID.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 170, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        lblBookID.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 720, -1));

        jLabel2.setFont(new java.awt.Font("Simplified Arabic", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Quantiry :");
        lblBookID.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 120, -1));

        jLabel6.setFont(new java.awt.Font("Simplified Arabic", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Book Id :");
        lblBookID.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 120, -1));

        jLabel7.setFont(new java.awt.Font("Simplified Arabic", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Book Name :");
        lblBookID.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 120, -1));

        jLabel8.setFont(new java.awt.Font("Simplified Arabic", 3, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText(" Author :");
        lblBookID.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 120, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Male_100px.png"))); // NOI18N
        jLabel9.setText("Manage Students");
        lblBookID.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 280, 70));

        jLabel10.setFont(new java.awt.Font("Simplified Arabic", 3, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("student Id :");
        lblBookID.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, 120, -1));

        jLabel11.setFont(new java.awt.Font("Simplified Arabic", 3, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("student name :");
        lblBookID.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, 120, -1));

        jLabel12.setFont(new java.awt.Font("Simplified Arabic", 3, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("course name :");
        lblBookID.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 330, 120, -1));

        jLabel13.setFont(new java.awt.Font("Simplified Arabic", 3, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("branch :");
        lblBookID.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 390, 120, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        lblBookID.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 10, 480));

        lblBookId.setForeground(new java.awt.Color(255, 255, 255));
        lblBookID.add(lblBookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 110, -1));

        lblBookName.setFont(new java.awt.Font("Segoe UI Semibold", 3, 12)); // NOI18N
        lblBookName.setForeground(new java.awt.Color(255, 255, 255));
        lblBookID.add(lblBookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 130, 20));

        lblBookQuantity.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        lblBookQuantity.setForeground(new java.awt.Color(255, 255, 255));
        lblBookID.add(lblBookQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 110, 30));

        lblBookAuther.setFont(new java.awt.Font("Segoe UI Semibold", 3, 12)); // NOI18N
        lblBookAuther.setForeground(new java.awt.Color(255, 255, 255));
        lblBookID.add(lblBookAuther, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 100, 20));

        sbranch.setFont(new java.awt.Font("Segoe UI Semibold", 3, 14)); // NOI18N
        sbranch.setForeground(new java.awt.Color(255, 255, 255));
        lblBookID.add(sbranch, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 400, 150, -1));

        sID.setFont(new java.awt.Font("Segoe UI Semibold", 3, 14)); // NOI18N
        sID.setForeground(new java.awt.Color(255, 255, 255));
        lblBookID.add(sID, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 230, 150, -1));

        Sname.setFont(new java.awt.Font("Segoe UI Semibold", 3, 14)); // NOI18N
        Sname.setForeground(new java.awt.Color(255, 255, 255));
        lblBookID.add(Sname, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 290, 150, -1));

        Scourse.setFont(new java.awt.Font("Segoe UI Semibold", 3, 14)); // NOI18N
        Scourse.setForeground(new java.awt.Color(255, 255, 255));
        lblBookID.add(Scourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 340, 150, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI Light", 2, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel18.setText("  Back");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        lblBookID.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("X");
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });
        lblBookID.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 10, 220, 50));

        validB.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        validB.setForeground(new java.awt.Color(255, 255, 0));
        lblBookID.add(validB, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, 210, 40));

        validS.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        validS.setForeground(new java.awt.Color(255, 255, 0));
        lblBookID.add(validS, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 470, 230, 40));

        getContentPane().add(lblBookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 680));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Book_50px_1.png"))); // NOI18N
        jLabel14.setText("Loan Book");

        jPanel6.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 332, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("Book Id");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 51, 0));
        jLabel15.setText("Student Id");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 51, 0));
        jLabel16.setText("Loan date");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 51, 0));
        jLabel17.setText("Due date");

        txtBid.setForeground(new java.awt.Color(0, 0, 0));
        txtBid.setBorderColor(new java.awt.Color(51, 0, 0));
        txtBid.setBotonColor(new java.awt.Color(255, 51, 0));
        txtBid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBidFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBidFocusLost(evt);
            }
        });

        txtSid.setForeground(new java.awt.Color(0, 0, 0));
        txtSid.setBorderColor(new java.awt.Color(51, 0, 0));
        txtSid.setBotonColor(new java.awt.Color(255, 51, 0));
        txtSid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSidFocusLost(evt);
            }
        });

        dataLoan.setColorBackground(new java.awt.Color(51, 0, 0));

        dataDue.setColorBackground(new java.awt.Color(51, 0, 0));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 51, 0));
        rSMaterialButtonCircle1.setText("Loan");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });

        jLabel26.setBackground(new java.awt.Color(0, 0, 0));
        jLabel26.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 0, 0));
        jLabel26.setText("X");
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dataLoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtBid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dataDue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(60, 60, 60))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(rSMaterialButtonCircle1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtSid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dataLoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addComponent(dataDue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(rSMaterialButtonCircle1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 500, 680));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtBidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBidFocusLost
        try {
            // TODO add your handling code here:
            getBookDetails();
        } catch (Exception ex) {
            Logger.getLogger(LoanBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtBidFocusLost

    private void txtBidFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBidFocusGained
        // TODO add your handling code here:
 
    }//GEN-LAST:event_txtBidFocusGained

    private void txtSidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSidFocusLost
        try {
            // TODO add your handling code here:
            getStudentDetails();
        } catch (Exception ex) {
            Logger.getLogger(LoanBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtSidFocusLost

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel26MouseClicked

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        // TODO add your handling code here:
        if(lblBookQuantity.getText().equals("0")){
            JOptionPane.showMessageDialog(this, "this book is not avaliable now");

        }
        else{
                    if(isAlreadyLoaned() == false){
            if(loanBook() == true){
            JOptionPane.showMessageDialog(this, "loaned succesfully");
            try {
                updateBook();
            } catch (Exception ex) {
                Logger.getLogger(LoanBooks.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
         JOptionPane.showMessageDialog(this, "can't issue book");

        }
            
        }
        else{
            JOptionPane.showMessageDialog(this, "this student has already loaned this book");
        }
        }


    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        // TODO add your handling code here:
        HomePage hb = new HomePage();
        hb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel18MouseClicked

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
            java.util.logging.Logger.getLogger(LoanBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoanBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoanBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoanBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoanBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Scourse;
    private javax.swing.JLabel Sname;
    private rojeru_san.componentes.RSDateChooser dataDue;
    private rojeru_san.componentes.RSDateChooser dataLoan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblBookAuther;
    public static javax.swing.JPanel lblBookID;
    private javax.swing.JLabel lblBookId;
    private javax.swing.JLabel lblBookName;
    private javax.swing.JLabel lblBookQuantity;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private javax.swing.JLabel sID;
    private javax.swing.JLabel sbranch;
    public static rojerusan.RSMetroTextPlaceHolder txtBid;
    public static rojerusan.RSMetroTextPlaceHolder txtSid;
    private javax.swing.JLabel validB;
    private javax.swing.JLabel validS;
    // End of variables declaration//GEN-END:variables
}
