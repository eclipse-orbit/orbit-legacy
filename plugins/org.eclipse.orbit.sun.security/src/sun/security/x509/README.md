This "package" is empty and is available to satisfy what are presumed to be optional package imports of `sun.security.x509`.

Adding `-Dorg.osgi.framework.system.packages.extra=sun.security.x509` will allow the actual package and classes from the JDK to be used.

See the following issue for more details:

- https://github.com/eclipse-orbit/orbit-simrel/issues/15