# Environment Variables

## Environment Variables for Configuration
The configuration can be provided as a file and/or through environment variables. Mixing both sources is also possible. In that case environment variables have precedence over the configuration settings in the configuration file. 

The respective environment variables are documented in the configuration file templates:
* [Broker Configuration Template](broker-config-template.md)
* [Gateway Configuration Template](gateway-config-template.md)

## Environment Variables for Operators
The following environment variables are intended for operators:
  - `ZEEBE_LOG_LEVEL`: Sets the log level of the Zeebe Logger (default: `info`).
 
 ## Environment Variables for Developers 
The following environment variables are intended for developers:
 - `SPRING_PROFILES_ACTIVE=dev`: If this is set, the broker will start in a temporary folder and all data will be cleaned up upon exit
 - `ZEEBE_DEBUG=true/false`: Activates a `DebugLogExporter` with default settings. The value of the environment variable toggles pretty printing

 > Note: It is not recommended to use these environment variables in production.