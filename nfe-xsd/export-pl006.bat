@echo off
setlocal EnableDelayedExpansion

cd PL_006r

set dirSource=../src/main/java

for %%f in (*.xsd) do (
	set file=%%f
	xjc -b ../binding.xml -target 2.1 %%f -d %dirSource% -p org.nfe.xsd.pl6.!file:~0,-10!
)

xjc -b ../binding.xml -target 2.1 xmldsig-core-schema_v1.01.xsd -d %dirSource% -p org.nfe.xsd.pl6.xmldsig
