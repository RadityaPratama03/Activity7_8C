<?php 
  include "./koneksi.php";

  $hasil = mysqli_query($koneksi,"SELECT * from teman");

  $json = array();

  while($row = mysqli_fetch_assoc($hasil)){
    $json[] = $row;
  }

  echo json_encode($json);
  mysqli_close($koneksi);
?>