$jar = "..\..\..\target\spring-cds-demo-0.0.1-SNAPSHOT.jar"
$cdsfile = "spring-cds-demo.jsa"
$runs = 5

Write-Host "=== SANS AppCDS ==="
for ($i=1; $i -le $runs; $i++) {
    $start = Get-Date
    java -jar $jar | Out-Null
    $end = Get-Date
    Write-Host ("Demarrage $i : " + ($end - $start).TotalMilliseconds + " ms")
}

Write-Host "`n=== AVEC AppCDS ==="
for ($i=1; $i -le $runs; $i++) {
    $start = Get-Date
    java -Xshare:on -XX:SharedArchiveFile=$cdsfile -jar $jar | Out-Null
    $end = Get-Date
    Write-Host ("Demarrage $i : " + ($end - $start).TotalMilliseconds + " ms")
}