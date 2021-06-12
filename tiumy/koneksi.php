<?php 
  $server = "localhost";
  $user = "root";
  $namaDB = "TIUMY";
  $password = "";
  
  $koneksi =  mysqli_connect($server,$user,$password,$namaDB) or die("Koneksi gagal!");
?>