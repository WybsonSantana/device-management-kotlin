# device-management-kotlin

Serviço de **Device Management** da plataforma KSensors, responsável pela capacidade de negócio de **Gestão de Sensores**.

## Descrição

Cuida do cadastro, configuração e gerenciamento remoto dos sensores, garantindo que todos os dispositivos sejam registrados, ativados, desativados e atualizados de forma centralizada, independentemente da tecnologia utilizada por cada sensor.

## Funcionalidades Principais

- Cadastro de sensores
- Gerenciamento remoto de sensores

## Endpoints

| Método | Endpoint | Descrição |
| --- | --- | --- |
| `POST` | `/api/sensors` | Cadastra um novo sensor |
| `GET` | `/api/sensors` | Lista todos os sensores |
| `GET` | `/api/sensors/{sensorId}` | Obtém sensor específico |
| `PUT` | `/api/sensors/{sensorId}` | Atualiza sensor específico |
| `DELETE` | `/api/sensors/{sensorId}` | Remove sensor específico |
| `PUT` | `/api/sensors/{sensorId}/enable` | Ativa sensor específico |
| `DELETE` | `/api/sensors/{sensorId}/enable` | Desativa sensor específico |

## Objetos de Negócio

### Sensor

| Propriedade | Tipo |
| --- | --- |
| Id | TSID |
| Name | String |
| Location | String |
| IP | String |
| Protocol | String |
| Model | String |
| Enabled | Boolean |

## Tecnologias Utilizadas

- Linguagem de Programação: Kotlin
- Banco de Dados: Postgres

## Comunicação com Outros Serviços

- **Síncrona (HTTP/REST)**: Envia uma requisição ao Temperature Monitoring Service para desativar o monitoramento caso um sensor seja desativado.

## Papel na Solução

Este serviço resolve os problemas de **falta de centralização de dados** e de **configuração manual e descentralizada dos sensores**: todos os sensores são gerenciados e monitorados a partir de uma única plataforma, e a configuração remota (ativação, desativação, atualização) é feita através de uma interface única via endpoints RESTful, sem a necessidade de acessar cada sensor individualmente.
