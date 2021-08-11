# InformationClubWifiMS
proyect onissolutions - microservices sprint boot use maven Dependency management

******Requirement****

java 1.8

spring boot 2.5.3

apache maven 3.8.1 

example endpoint type GET: 
http://localhost:8080/api/informationclubwifi/getInformation

example endpoint type POST: request xml and response xml 
http://localhost:8080/api/informationclubwifi/processReceive

    request
        <?xml version="1.0" encoding="UTF-8"?>
        <process>
            <Account>1234567890</Account>
        </process>

    response

        <InfClubWifiEnvelopeModel>
            <Header>
                <MessageID>urn:f99e26c3-ef9c-11eb-854c-02429dba36fc</MessageID>
                <ReplyTo>
                    <Address>http://www.w3.org/2005/08/addressing/anonymous</Address>
                    <ReferenceParameters>
                        <ecid>8b8e86ca-40cc-488e-9116-43f5012ca670-0001151a</ecid>
                        <FlowEventId>54678</FlowEventId>
                        <FlowId>234234</FlowId>
                        <CorrelationFlowId>0000Nfh1lt7Bl3k_Ox9Did1WzztQ0000sA</CorrelationFlowId>
                        <quiescing.SCAEntityId>820112</quiescing.SCAEntityId>
                    </ReferenceParameters>
                </ReplyTo>
            </Header>
            <Body>
                <processResponse>
                    <Result>
                        <IdResult>0000</IdResult>
                        <Result>0</Result>
                        <ResultDescription>Peticion realizada con exito</ResultDescription>
                    </Result>
                    <Name>alfredo del angel perez</Name>
                    <Phone>5671012256</Phone>
                    <Email>alfredo_93939@onissolutions.con</Email>
                </processResponse>
            </Body>
        </InfClubWifiEnvelopeModel>


start docker imagen optional
docker run -it -p 8080:8080 informationclubwifi .



