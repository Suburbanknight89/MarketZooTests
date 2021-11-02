
## тестовое здание

![Intelij_IDEA](src/test/resources/img/icons/Intelij_IDEA.png)![Java](src/test/resources/img/icons/Java.png)![Selenide](src/test/resources/img/icons/Selenide.png)![Selenoid](src/test/resources/img/icons/Selenoid.png)![Gradle](src/test/resources/img/icons/Gradle.png)![JUnit5](src/test/resources/img/icons/JUnit5.png)![Allure Report](src/test/resources/img/icons/Allure_Report.png)![AllureTestOps](src/test/resources/img/icons/AllureTestOps.png)![Github](src/test/resources/img/icons/Github.png)![Jenkins](src/test/resources/img/icons/Jenkins.png)![Rest-Assured](src/test/resources/img/icons/Rest-Assured.png)![Telegram](src/test/resources/img/icons/Telegram.png)![Jira](src/test/resources/img/icons/Jira.png)

Реализованы проверки:

## UI Автотесты на http://yandex.market.ru/

UI

    Открыть https://market.yandex.ru/
    Нажать кнопку 'каталог'
    Навести курсор на «Зоотовары, в блоке «Для кошек» нажать на «Лакомства»
    Установить фильтры и нажать 'сравнить'
    Перейти в первый товар в списке, нажать на кнопку «Сравнить»
    Вернуться на предыдущую страницу
    В фильтре снять галочку с производителя «Whiskas» и установить производителя «Мнямс»
    Перейти во второй товар в списке, нажать на кнопку «Сравнить» 
    Перейти в «Сравнение», проверить, что имена товаров в сравнении соответствуют
    Проверить, что сумма стоимостей товаров не превышает 300 руб
    Удалить товар производителя «Whiskas» из сравнения и проверить, что товар производителя «Whiskas» не отображается
    Нажать на «Удалить список» (значок мусорного бака), проверить, что товары не отображаются 



### Запуск тестов

Локальный запуск:

    gradle clean test

Локальный запуск с количественным параметром запускаемых потоков:

    gradle clean test -Dthreads=5

Удаленный запуск тестов:

    gradle clean test -Ddriver=remote


Запуск тестов через джобу в [Jenkins](https://jenkins.autotests.cloud/job/MarketZooTests/build?delay=0sec)

### Параметры используемые при запуске тестов:
![JENKINS_PARAMS](src/test/resources/img/Jenkins_params.PNG)

### Статистика запусков:

![JENKINS_LAUNCH](src/test/resources/img/JENKINS_LAUNCH.PNG)

### Отчёт в Allure Report
![Allure](src/test/resources/img/allure_report.PNG)

### Интеграция [Allure Test Ops](https://allure.autotests.cloud/project/627/dashboards) с [Jira](https://jira.autotests.cloud/browse/HOMEWORK-250)  :

![JIRA](src/test/resources/img/jira_integration.PNG)

### Хранение тест-кейсов в Allure TestOps
Дашборд

![Allure](src/test/resources/img/main_dashboard.PNG)
Дашборд по видам тестов

![Allure](src/test/resources/img/personal_dashboards.PNG)
Запуски

![Allure](src/test/resources/img/launches.PNG)
Результат запуска

![Allure](src/test/resources/img/launch_results.PNG)
Тест-кейсы

![Allure](src/test/resources/img/tests.PNG)

### Видео о прохождении тестов
![Selenoid](src/test/resources/img/381ea424ae9fd94501a1efc8ceff696b(1).gif)

### Уведомления о завершении прогона автотестов в Telegram
![Telegram](src/test/resources/img/tgbot.PNG)