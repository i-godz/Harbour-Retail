# Harbour Retail Datawarehouse

The DataHarbor Organization, a fictional company, aims to enable data-driven decision-making in their retail domain by implementing a comprehensive data integration and analysis solution. The primary focus is to embrace a data-driven approach to steer their business forward, bridging the gap between raw data and actionable insights.

The repository is structured as follows:
- `Input Data`: This directory contains the xlsx data files.
- `HARBOUR_RETAIL`: This directory contains talend files used for data integeration.
- `SQL Scripts`: This directory contains SQL DDL scripts.


# Project Scope:

• DATAHARBOR seeks an extensive view of its yearly sales, both as a collective entity and a granular analysis by each store. <br>
• The project aims to pinpoint the store that boasts the highest sales performance, furnishing DATAHARBOR with vital operational insights. <br>
• By determining the best salesperson across each store and the entire organization, DATAHARBOR organization can recognize and reward excellence. <br>
•  Accurate supplier identification supports DATAHARBOR in maintaining reliable partnerships. <br>
• From the best-selling product to least selling, DATAHARBOR needs a comprehensive product analysis. <br>


# Architecture

The architecture and design of the DATAHARBOR Retail Data Warehouse Integration Project encompass a systematic blueprint that is specific to business requirements and facilitates efficient data processing, storage, and analysis.

<p align="center">
  <img src="https://drive.google.com/uc?export=view&id=1O49esErzIDbnVSrYyZhbt0TN63GscoX2" />
</p>



## Data Transformation and Cleansing

The extracted undergoes data transformation and cleansing involving the below steps:

• Removal of duplicate records to ensure data integrity. <br>
• Schema validation to align with the predefined data structure. <br>
• Handling of null values and anomalies. <br>


## ETL Processes and Talend

The transformation process is completed through Extract, Transform, Load (ETL) procedures. Talend, a robust ETL tool, acts as a prominent stage, providing a versatile environment for implementing complex transformations and orchestrating the flow of data. Talend's capabilities allow DATAHARBOR organization to maintain data according to their specific business requirements.


## Star Schema 

The project employs a star schema design to facilitate efficient data analysis. Within this schema:

• Dimension tables (Employee, Store, Supplier) offer context and attributes for slicing and dicing data. <br>
• The fact table (Sales) serves as the central repository of quantitative data. <br>
• Logging tables within Talend to maintain a detailed record of job status and relevant information.

<p align="center">
  <img src="https://drive.google.com/uc?export=view&id=1O18hhfO9Ezc4i6kp3K4VK5vE2gf8fmTo" />
</p>

