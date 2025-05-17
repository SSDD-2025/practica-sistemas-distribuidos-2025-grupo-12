$DockerUser = "dmunozm5"
$ImageName = "pixeltrade"
$Tag = "latest"

$FullImageName = "$DockerUser/$ImageName:$Tag"

Write-Host "Building Docker image: $FullImageName"
docker build -t $FullImageName .

if ($LASTEXITCODE -ne 0) {
    Write-Host "Docker build failed." -ForegroundColor Red
    exit $LASTEXITCODE
}

Write-Host "Image built successfully." -ForegroundColor Green
