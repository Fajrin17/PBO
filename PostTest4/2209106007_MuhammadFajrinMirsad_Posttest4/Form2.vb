Imports MySql.Data.MySqlClient

Public Class Form2
    Public id As Integer

    Dim jenis As String

    Sub aturGrid()
        DataGridView1.Columns(0).Width = 60
        DataGridView1.Columns(1).Width = 200
        DataGridView1.Columns(2).Width = 200
        DataGridView1.Columns(3).Width = 200
        DataGridView1.Columns(4).Width = 200
        DataGridView1.Columns(0).HeaderText = "Kode Pos"
        DataGridView1.Columns(1).HeaderText = "Lokasi Pos"
        DataGridView1.Columns(2).HeaderText = "Jenis Pos"
        DataGridView1.Columns(3).HeaderText = "Tanggal Operasi Pos"
        DataGridView1.Columns(4).HeaderText = "Kecamatan Pos"
    End Sub

    Sub tampilJenis()
        DA = New MySqlDataAdapter("SELECT * FROM tb_pos", CONN)
        DS = New DataSet
        DS.Clear()
        DA.Fill(DS, "pos")
        DataGridView1.DataSource = DS.Tables("pos")
        DataGridView1.Refresh()
    End Sub

    Private Sub Form2_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        koneksi()
        tampilJenis()
        aturGrid()
    End Sub

    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        Me.Close()
        Form1.Show()
    End Sub

    Private Sub DataGridView1_CellClick(sender As Object, e As DataGridViewCellEventArgs) Handles DataGridView1.CellClick
        If DataGridView1.SelectedRows.Count > 0 Then
            Dim row As DataGridViewRow = DataGridView1.SelectedRows(0)
            If row.Index < DataGridView1.RowCount - 1 And row.Index >= 0 Then
                id = row.Cells(0).Value
                TextBox1.Text = row.Cells(1).Value
                For Each ctrl As Control In GroupBox1.Controls
                    If TypeOf ctrl Is RadioButton Then
                        If (DirectCast(ctrl, RadioButton).Text = row.Cells(2).Value) Then
                            DirectCast(ctrl, RadioButton).Checked = True
                        End If
                    End If
                Next
                ComboBox1.SelectedIndex = ComboBox1.Items.IndexOf(row.Cells(4).Value)
            End If
        End If
    End Sub

    Private Sub btnUbah_Click(sender As Object, e As EventArgs) Handles btnUbah.Click
        cekRadio()
        If TextBox1.Text <> "" And jenis <> "" And ComboBox1.Text <> "" Then
            CMD = New MySqlCommand("UPDATE tb_pos SET lokasi_pos = '" & TextBox1.Text & "',jenis_pos = '" & jenis & "',tanggal_mulai_operasi = '" & DateTimePicker1.Value.ToString("yyyy-MM-dd") & "', kecamatan = '" & ComboBox1.Text & "' WHERE id_pos = " & id, CONN)
            Dim rowAffected As Integer = CMD.ExecuteNonQuery()
            If rowAffected > 0 Then
                MessageBox.Show("Berhasil Mengubah Data Pos!", "Information", MessageBoxButtons.OK, MessageBoxIcon.Information)
                tampilJenis()
            Else
                MessageBox.Show("Gagal Mengubah Data Pos!", "Warning", MessageBoxButtons.OK, MessageBoxIcon.Warning)
            End If
        Else
            MessageBox.Show("Harap Inputkan Data!", "Warning", MessageBoxButtons.OK, MessageBoxIcon.Warning)
        End If
    End Sub

    Private Sub btnHapus_Click(sender As Object, e As EventArgs) Handles btnHapus.Click
        If id = Nothing Then
            MessageBox.Show("Harap Pilih Data Yang Ingin Dihapus!", "Warning", MessageBoxButtons.OK, MessageBoxIcon.Warning)
        Else
            Dim ubah As String = "delete from tb_pos where id_pos = '" & id & "'"
            CMD = New MySqlCommand(ubah, CONN)
            CMD.ExecuteNonQuery()
            MessageBox.Show("Data Berhasil Dihapus!", "Information", MessageBoxButtons.OK, MessageBoxIcon.Information)
            tampilJenis()
        End If
    End Sub

    Private Sub txtSearch_KeyPress(sender As Object, e As KeyPressEventArgs) Handles txtSearch.KeyPress
        If e.KeyChar = Chr(13) Then
            CMD = New MySqlCommand("SELECT * FROM tb_pos where lokasi_pos like '%" & txtSearch.Text & "%' OR jenis_pos like '%" & txtSearch.Text & "%' OR kecamatan like '%" & txtSearch.Text & "%'", CONN)
            RD = CMD.ExecuteReader()
            RD.Read()

            If RD.HasRows Then
                RD.Close()
                DA = New MySqlDataAdapter("SELECT * FROM tb_pos where lokasi_pos like '%" & txtSearch.Text & "%' OR jenis_pos like '%" & txtSearch.Text & "%' OR kecamatan like '%" & txtSearch.Text & "%'", CONN)
                DS = New DataSet
                DA.Fill(DS, "Dapat")
                DataGridView1.DataSource = DS.Tables("Dapat")
                DataGridView1.ReadOnly = True
            Else
                MessageBox.Show("Data Tidak Ditemukan", "Warning", MessageBoxButtons.OK, MessageBoxIcon.Warning)
            End If
        End If
    End Sub

    Sub cekRadio()
        For Each ctrl As Control In GroupBox1.Controls
            If TypeOf ctrl Is RadioButton Then
                If (DirectCast(ctrl, RadioButton).Checked) Then
                    jenis = DirectCast(ctrl, RadioButton).Text
                End If
            End If
        Next
    End Sub
End Class