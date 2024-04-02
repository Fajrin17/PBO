Imports MySql.Data.MySqlClient

Public Class Form1

    Dim jenis As String

    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        koneksi()
    End Sub

    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        cekRadio()
        If TextBox1.Text <> "" And jenis <> "" And ComboBox1.Text <> "" Then
            CMD = New MySqlCommand("INSERT INTO tb_pos VALUES (NULL,'" & TextBox1.Text & "','" & jenis & "','" & DateTimePicker1.Value.ToString("yyyy-MM-dd") & "','" & ComboBox1.Text & "')", CONN)
            Dim rowAffected As Integer = CMD.ExecuteNonQuery()
            If rowAffected > 0 Then
                MessageBox.Show("Berhasil Menambahkan Pos!", "Information", MessageBoxButtons.OK, MessageBoxIcon.Information)
                Me.Hide()
                Form2.Show()
            Else
                MessageBox.Show("Gagal Menambahkan Pos!", "Warning", MessageBoxButtons.OK, MessageBoxIcon.Warning)
            End If
        Else
            MessageBox.Show("Harap Inputkan Data!", "Warning", MessageBoxButtons.OK, MessageBoxIcon.Warning)
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

    Private Sub Button2_Click(sender As Object, e As EventArgs) Handles Button2.Click
        Me.Hide()
        Form2.Show()
    End Sub
End Class
