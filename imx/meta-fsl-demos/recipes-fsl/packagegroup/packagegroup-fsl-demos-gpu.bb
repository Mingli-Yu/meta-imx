# Copyright (C) 2012-2014 Freescale Semiconductor
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Freescale's package group used to add the packages of GPU demos and tools."
SUMMARY = "Freescale package group - demos/tools"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

APITRACE_INSTALL = ""
APITRACE_INSTALL_append_mx6q = " imx-apitrace"
APITRACE_INSTALL_append_mx6dl = " imx-apitrace"
APITRACE_INSTALL_append_mx6sx = " imx-apitrace"

RDEPENDS_${PN}_mx6 = " \
    gpu-viv-tools-mx6 \
    gpu-viv-demos-mx6 \
    APITRACE_INSTALL \
"
