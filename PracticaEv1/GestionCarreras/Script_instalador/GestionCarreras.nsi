# Script de generación del instalador para la aplicación "Carreras1.0"
# Nombre del instalador
Name "setup.exe"

# Nombre del ejecutable
OutFile "Carreras1.0_Setup.exe"

# Definicion del directorio donde se va a instalar
InstallDir $PROGRAMFILES\GestionCarreras_1.0

# Solicitud de permisos para Windows
RequestExecutionLevel admin

# Pantallas que se mostraran durante la instalacion
Page directory
Page instfiles

#Asignacion del idioma del instalador
!include "MUI.nsh"
!insertmacro MUI_LANGUAGE "Spanish"

#Asignacion del icono para el instalador
Icon "icono.ico"

#---------------------------------------------------------------------------------------------------

##SECCION DEDICADA AL INSTALADOR #
# Apertura de la seccion
Section

	#-----------------------------------------------------------------------------------------
	
	##ESCRITURA DE FICHEROS DE LA APLICACION #
	# Definimos la ruta en la que vamos a escribir los ficheros de la aplicacion
	SetOutPath $INSTDIR\app
	
	# Ponemos los ficheros en la ruta especificada
	File    .\dist\GestionCarreras.jar
	File /r .\dist\lib
	File /r .\data 
	File /r .\informes
	File /r .\help
	
	# definimos el desinstalador y su nombre
	WriteUninstaller $INSTDIR\uninstaller.exe
	
	
	#------------------------------------------------------------------------------------------
	
	##ACCESOS DIRECTOS ##
	
    # Creamos un acceso directo en el directorio de instalacion para lanzar la aplicacion
	CreateShortCut "$INSTDIR\Carreras1.0.lnk" "$INSTDIR\app\GestionCarreras.jar"
	
	# Creamos un acceso directo en el escritorio.
	CreateShortCut "$DESKTOP\Carreras1.0.lnk" "$INSTDIR\app\GestionCarreras.jar"
	
	# Creamos una carpeta en el menu inicio para los accesos directos
	CreateDirectory $SMPROGRAMS\Carreras1.0

	# Creamos un acceso directo en el menu inicio apuntando al desinstalador
	CreateShortCut "$SMPROGRAMS\Carreras1.0\Desinstalar_Carreras1.0.lnk" "$INSTDIR\uninstaller.exe"
	
	# Creamos un acceso directo en el menu de inicio.
	CreateShortCut "$SMPROGRAMS\Carreras1.0\Carreras1.0.lnk" "$INSTDIR\app\GestionCarreras.jar"
	
	#--------------------------------------------------------------------------------------------
	
	##MODIFICACION DEL REGISTRO ##
	
	#Añadimos información para que salga en el menú de desinstalar de Windows
    WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Carreras1.0" \
                "DisplayName" "Carreras1.0"
	WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Carreras1.0" \
                "Publisher" "Guile - DI 2019"
	WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Carreras1.0" \
                "UninstallString" "$\"$INSTDIR\uninstaller.exe$\""
				 
# fin de la seccion
SectionEnd

#---------------------------------------------------------------------------------------------------

UninstallText "Realmente quieres desinstalar Carreras1.0, Pulsa siguiente para continuar."

##SECCION DEDICADA AL DESINSTALADOR #
# Apertura de la seccion
Section "Uninstall"
	 
	
	
	# Borramos primero el desinstalador
	Delete $INSTDIR\uninstaller.exe
	
	# borramos los archivos que habiamos instalado
	RmDir  /r $INSTDIR\app\informes\..
	RmDir  /r $INSTDIR\app\help\..
	RmDir  /r $INSTDIR\app\data\..
	RmDir  /r $INSTDIR\app\dist\lib\..
	Delete    $INSTDIR\app\dist\GestionCarreras.jar

	# borramos el acceso directo del directorio principal
    Delete "$INSTDIR\Carreras1.0.lnk"
	
	# borramos los accesos directos del menu de inicio
    Delete "$SMPROGRAMS\Carreras1.0\Desinstalar_Carreras1.0.lnk"
	Delete "$SMPROGRAMS\Carreras1.0\Carreras1.0.lnk"
	
	# borramos el acceso directo del menu de inicio
    Delete "$DESKTOP\Carreras1.0.lnk"
	
	# Borramos el directorio principal
	RmDir "$INSTDIR"
	
	# Borramos la entrada del registro
	DeleteRegKey HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Carreras1.0"

# fin de la seccion
SectionEnd
