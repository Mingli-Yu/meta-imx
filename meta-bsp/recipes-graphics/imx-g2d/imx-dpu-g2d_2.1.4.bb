# Copyright (C) 2016 Freescale Semiconductor
# Copyright 2017-2022 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "G2D library using i.MX DPU"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://COPYING;md5=5a0bf11f745e68024f37b4724a5364fe" 

DEPENDS = "libgal-imx libdrm"
PROVIDES += "virtual/libg2d"

SRC_URI = "${FSL_MIRROR}/${BPN}-${PV}.bin;fsl-eula=true"
SRC_URI[md5sum] = "583c930f47ab9edecb10554ead0faa91"
SRC_URI[sha256sum] = "9416f6dee0f2128e74c6ba462d26fb160b192b72818da0c79cf23bd41987e613"

inherit fsl-eula-unpack

do_install () {
    install -d ${D}${libdir}
    install -d ${D}${includedir}
    cp -r ${S}/g2d/usr/lib/*.so* ${D}${libdir}
    cp -Pr ${S}/g2d/usr/include/* ${D}${includedir}
}

INSANE_SKIP:${PN} += "ldflags"

COMPATIBLE_MACHINE = "(imxdpu)"
