## /novademo
```text
暂无描述
```
#### 公共Header参数
参数名 | 示例值 | 参数描述
--- | --- | ---
暂无参数
#### 公共Query参数
参数名 | 示例值 | 参数描述
--- | --- | ---
暂无参数
#### 公共Body参数
参数名 | 示例值 | 参数描述
--- | --- | ---
暂无参数
#### 预执行脚本
```javascript
暂无预执行脚本
```
#### 后执行脚本
```javascript
暂无后执行脚本
```
## /novademo/delete
```text
暂无描述
```
#### 接口状态
> 开发中

#### 接口URL
> http://192.168.161.131:8080/nova/user/delete?id=5

#### 请求方式
> GET

#### Content-Type
> form-data

#### 请求Query参数
参数名 | 示例值 | 参数类型 | 是否必填 | 参数描述
--- | --- | --- | --- | ---
id | 5 | Text | 是 | -
#### 预执行脚本
```javascript
暂无预执行脚本
```
#### 后执行脚本
```javascript
暂无后执行脚本
```
## /novademo/getById
```text
暂无描述
```
#### 接口状态
> 开发中

#### 接口URL
> http://192.168.161.131:8080/nova/user/getById?id=5

#### 请求方式
> GET

#### Content-Type
> form-data

#### 请求Query参数
参数名 | 示例值 | 参数类型 | 是否必填 | 参数描述
--- | --- | --- | --- | ---
id | 5 | Text | 是 | -
#### 预执行脚本
```javascript
暂无预执行脚本
```
#### 后执行脚本
```javascript
暂无后执行脚本
```
## /novademo/getAll
```text
暂无描述
```
#### 接口状态
> 开发中

#### 接口URL
> http://192.168.161.131:8080/nova/user/getAll

#### 请求方式
> GET

#### Content-Type
> form-data

#### 预执行脚本
```javascript
暂无预执行脚本
```
#### 后执行脚本
```javascript
暂无后执行脚本
```
## /novademo/update
```text
暂无描述
```
#### 接口状态
> 开发中

#### 接口URL
> http://192.168.161.131:8080/nova/user/update

#### 请求方式
> POST

#### Content-Type
> json

#### 请求Header参数
参数名 | 示例值 | 参数类型 | 是否必填 | 参数描述
--- | --- | --- | --- | ---
Content-Type | application/json | Text | 是 | -
#### 请求Body参数
```javascript
{
        "id": "9",
        "username": "成龙",
        "email": "chenglong@163.com",
        "address": "香港",
        "createTime": "2022-07-07T18:39:57",
        "deleted": "0"
    }
```
#### 预执行脚本
```javascript
暂无预执行脚本
```
#### 后执行脚本
```javascript
暂无后执行脚本
```
## /novademo/page
```text
暂无描述
```
#### 接口状态
> 开发中

#### 接口URL
> http://192.168.161.131:8080/nova/user/page?currentPage=1&pageSize=2

#### 请求方式
> GET

#### Content-Type
> form-data

#### 请求Query参数
参数名 | 示例值 | 参数类型 | 是否必填 | 参数描述
--- | --- | --- | --- | ---
currentPage | 1 | Text | 是 | -
pageSize | 2 | Text | 是 | -
#### 预执行脚本
```javascript
暂无预执行脚本
```
#### 后执行脚本
```javascript
暂无后执行脚本
```
## /novademo/save
```text
暂无描述
```
#### 接口状态
> 开发中

#### 接口URL
> http://192.168.161.131:8080/nova/user/save

#### 请求方式
> POST

#### Content-Type
> json

#### 请求Header参数
参数名 | 示例值 | 参数类型 | 是否必填 | 参数描述
--- | --- | --- | --- | ---
Content-Type | application/json | Text | 是 | -
#### 请求Body参数
```javascript
{
	"id": "9",
	"username": "成龙",
	"email": "chenglong@163.com",
	"address": "香港"
}
```
#### 预执行脚本
```javascript
暂无预执行脚本
```
#### 后执行脚本
```javascript
暂无后执行脚本
```