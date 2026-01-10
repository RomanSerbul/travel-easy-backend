-- Update Carpathian group tours with comprehensive details provided by user

-- Update Mikulichin tour with detailed program information
UPDATE tour_proposals
SET 
    description = 'Микуличин — одне з наймальовничіших карпатських сіл, розташоване в долині річки Прут, серед гір, лісів і полонин. Це ідеальне місце для тих, хто хоче відчути справжню атмосферу Карпат, насолодитися чистим повітрям і дізнатися більше про гуцульські традиції.',
    includes = 'Проживання у комфортних номерах із зручностями
Три сніданки, дві вечері
Проїзд комфортабельним автобусом
Трансфер по всьому маршруту
Супровід професійного гіда
Екскурсійна програма
Організаційний супровід групи',
    exclusions = 'Вхідні квитки
Майстер-класи
Джипи, коні, чани, квадроцикли
Дегустації
Особисті витрати',
    policy = 'Скасування за 14+ днів — повернення 100%
Скасування за 7–13 днів — повернення 50%
Скасування менше ніж за 7 днів — без повернення
Мінімальна група 15 осіб',
    program_details = 'День 1: Приїзд у Микуличин, знайомство з селом і його мешканцями. День 2: Екскурсії до водоспадів, похід на гору, відвідування музею. День 3: Активні розваги, вільний час, від''їзд.',
    target_audience = 'Сім''ї з дітьми, туристи будь-якого віку, люди, що бажають познайомитися з гуцульською культурою'
WHERE slug = 'mikulichin-group-tour';

-- Clear and repopulate attractions for Mikulichin
DELETE FROM tour_proposal_attractions WHERE tour_proposal_id = (SELECT id FROM tour_proposals WHERE slug = 'mikulichin-group-tour');
INSERT INTO tour_proposal_attractions (tour_proposal_id, attraction)
SELECT id, 'Водоспад Женецький Гук — 15-метровий водоспад в горах Карпат, дуже популярний серед туристів' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'Водоспад Капливець — красивий каскадний водоспад' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'Озеро Несамовите — мальовниче озеро серед гір' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'Гора Маковиця — історичні сліди воєн, панорамні види' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'Стежка Довбуша — легендарна гуцульська стежка серед лісу' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'Велика карпатська гойдалка — фотолокація та відпочинок' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'Музей традиційної гуцульської культури' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'Місцева пивоварня «Микуличинська» з дегустацією' FROM tour_proposals WHERE slug = 'mikulichin-group-tour';

-- Clear and repopulate activities for Mikulichin
DELETE FROM tour_proposal_activities WHERE tour_proposal_id = (SELECT id FROM tour_proposals WHERE slug = 'mikulichin-group-tour');
INSERT INTO tour_proposal_activities (tour_proposal_id, activity)
SELECT id, 'Кінні прогулянки верхи, катання бричкою або санями' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'Джип-тури в гори з гідом' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'Риболовля' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'Квадроцикли — пригоди на гірських маршрутах' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'Піші маршрути з гідом на гору' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'Майстер-клас по приготуванню баношу' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'Дегустація гуцульського сиру та настоянок' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'Майстер-клас гуцульського танцю' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'Майстер-клас по виготовленню ляльки-мотанки' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'Відвідування традиційних гуцульських садиб' FROM tour_proposals WHERE slug = 'mikulichin-group-tour';

-- Clear and repopulate highlights for Mikulichin
DELETE FROM tour_proposal_highlights WHERE tour_proposal_id = (SELECT id FROM tour_proposals WHERE slug = 'mikulichin-group-tour');
INSERT INTO tour_proposal_highlights (tour_proposal_id, highlight)
SELECT id, 'Автентична атмосфера карпатського села' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'Захопливі панорами гір та долин' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'Велика гуцульська гойдалка — фотолокація з видами' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'Можливість дегустувати місцеві продукти' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'Спілкування з гідом про гуцульські легенди та традиції' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'Насичена, але комфортна програма' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'Відвідування музею звичаєвої символіки Гуцульщини' FROM tour_proposals WHERE slug = 'mikulichin-group-tour'
UNION ALL SELECT id, 'Безпечний і організований формат подорожі' FROM tour_proposals WHERE slug = 'mikulichin-group-tour';

-- Update Vorokhta tour with detailed information
UPDATE tour_proposals
SET 
    description = 'Ворохта — відомий карпатський курорт, розташований у серці Гуцульщини, серед гір, хвойних лісів і стрімких потоків. Селище приваблює туристів унікальними інженерними спорудами, гірськими краєвидами та автентичною гуцульською атмосферою.',
    includes = 'Прибуття до Ворохти комфортабельним автобусом
Комфортне проживання
Найсмачніша гуцульська кухня (сніданки та вечері)
Трансфер по всьому маршруту
Супровід професійного гіда
Екскурсійна програма
Організаційний супровід групи',
    exclusions = 'Вхідні квитки
Майстер-класи
Джипи, чани, коні, квадроцикли
Дегустації
Особисті витрати',
    policy = 'Скасування за 14+ днів — повернення 100%
Скасування за 7–13 днів — повернення 50%
Скасування менше ніж за 7 днів — без повернення
Мінімальна група 15 осіб',
    program_details = 'День 1: Приїзд у Ворохту, знайомство з віадуками та трамплін. День 2: Джип-тури, посещення приватного музею «Феєрія карпатського духу», майстер-класи та дегустація. День 3: Природні маршрути, прогулянка парком, вільний час, від''їзд.',
    target_audience = 'Туристи будь-якого віку, любителі історії та архітектури, шукачі адреналіну, люди, що цікавляться карпатською культурою'
WHERE slug = 'vorokhta-group-tour';

-- Clear and repopulate attractions for Vorokhta
DELETE FROM tour_proposal_attractions WHERE tour_proposal_id = (SELECT id FROM tour_proposals WHERE slug = 'vorokhta-group-tour');
INSERT INTO tour_proposal_attractions (tour_proposal_id, attraction)
SELECT id, 'Австрійські кам''яні віадуки — пам''ятки інженерного мистецтва' FROM tour_proposals WHERE slug = 'vorokhta-group-tour'
UNION ALL SELECT id, 'Ворохтянський трамплін — панорамні види Карпат' FROM tour_proposals WHERE slug = 'vorokhta-group-tour'
UNION ALL SELECT id, 'Карпатський національний природний парк' FROM tour_proposals WHERE slug = 'vorokhta-group-tour'
UNION ALL SELECT id, 'Дерев''яна церква Різдва Пресвятої Богородиці XVII ст.' FROM tour_proposals WHERE slug = 'vorokhta-group-tour'
UNION ALL SELECT id, 'Приватний музей «Феєрія карпатського духу»' FROM tour_proposals WHERE slug = 'vorokhta-group-tour'
UNION ALL SELECT id, 'Гири Шпиці, Ребра, Піп Іван Чорногірський' FROM tour_proposals WHERE slug = 'vorokhta-group-tour'
UNION ALL SELECT id, 'Залізниця та історичні пам''ятки розвитку курорту' FROM tour_proposals WHERE slug = 'vorokhta-group-tour'
UNION ALL SELECT id, 'Гуцульська архітектура та традиції селища' FROM tour_proposals WHERE slug = 'vorokhta-group-tour';

-- Clear and repopulate activities for Vorokhta
DELETE FROM tour_proposal_activities WHERE tour_proposal_id = (SELECT id FROM tour_proposals WHERE slug = 'vorokhta-group-tour');
INSERT INTO tour_proposal_activities (tour_proposal_id, activity)
SELECT id, 'Кінні прогулянки верхи, катання бричкою або санями' FROM tour_proposals WHERE slug = 'vorokhta-group-tour'
UNION ALL SELECT id, 'Джип-тури в гори з гідом' FROM tour_proposals WHERE slug = 'vorokhta-group-tour'
UNION ALL SELECT id, 'Квадроцикли — пригоди на гірських маршрутах' FROM tour_proposals WHERE slug = 'vorokhta-group-tour'
UNION ALL SELECT id, 'Риболовля' FROM tour_proposals WHERE slug = 'vorokhta-group-tour'
UNION ALL SELECT id, 'Посещення музею «Феєрія карпатського духу»' FROM tour_proposals WHERE slug = 'vorokhta-group-tour'
UNION ALL SELECT id, 'Майстер-класи по приготуванню баношу' FROM tour_proposals WHERE slug = 'vorokhta-group-tour'
UNION ALL SELECT id, 'Дегустація гуцульського сиру та настоянок' FROM tour_proposals WHERE slug = 'vorokhta-group-tour'
UNION ALL SELECT id, 'Майстер-клас гуцульського танцю' FROM tour_proposals WHERE slug = 'vorokhta-group-tour'
UNION ALL SELECT id, 'Прогулянка центральною частиною Ворохти' FROM tour_proposals WHERE slug = 'vorokhta-group-tour'
UNION ALL SELECT id, 'Піші маршрути з гідом' FROM tour_proposals WHERE slug = 'vorokhta-group-tour';

-- Clear and repopulate highlights for Vorokhta
DELETE FROM tour_proposal_highlights WHERE tour_proposal_id = (SELECT id FROM tour_proposals WHERE slug = 'vorokhta-group-tour');
INSERT INTO tour_proposal_highlights (tour_proposal_id, highlight)
SELECT id, 'Інженерна архітектура австрійських віадуків' FROM tour_proposals WHERE slug = 'vorokhta-group-tour'
UNION ALL SELECT id, 'Інтерактивна культурна програма в музеї «Феєрія»' FROM tour_proposals WHERE slug = 'vorokhta-group-tour'
UNION ALL SELECT id, 'Панорамні види Карпат із трампліна' FROM tour_proposals WHERE slug = 'vorokhta-group-tour'
UNION ALL SELECT id, 'Можливість торкатися магії карпатського духу' FROM tour_proposals WHERE slug = 'vorokhta-group-tour'
UNION ALL SELECT id, 'Знайомство з гуцульськими легендами та традиціями' FROM tour_proposals WHERE slug = 'vorokhta-group-tour'
UNION ALL SELECT id, 'Осмислена програма з майстер-класами та дегустаціями' FROM tour_proposals WHERE slug = 'vorokhta-group-tour'
UNION ALL SELECT id, 'Профільний екскурсовод з глибокими знаннями історії' FROM tour_proposals WHERE slug = 'vorokhta-group-tour';

-- Update Yaremche tour with detailed information
UPDATE tour_proposals
SET 
    description = 'Яремче — один із найпопулярніших карпатських курортів, розташований у долині річки Прут, серед мальовничих гір, смерекових лісів і водоспадів. Це місце гармонійно поєднує природну красу, гуцульські традиції та сучасну туристичну інфраструктуру.',
    includes = 'Прибуття до Яремче комфортабельним автобусом
Комфортне проживання
Найсмачніша гуцульська кухня (сніданки та вечері)
Трансфер по всьому маршруту
Супровід професійного гіда
Екскурсійна програма
Організаційний супровід групи',
    exclusions = 'Вхідні квитки
Майстер-класи
Джипи, чани, коні, квадроцикли
Дегустації
Особисті витрати',
    policy = 'Скасування за 14+ днів — повернення 100%
Скасування за 7–13 днів — повернення 50%
Скасування менше ніж за 7 днів — без повернення
Мінімальна група 15 осіб',
    program_details = 'День 1: Приїзд у Яремче, знайомство з селищем та водоспадом Пробій. День 2: Екскурсії до водоспадів, гойдалка над водоспадом, сувенірний ринок, стежка Довбуша. День 3: Активні розваги, вільний час у селищі, дегустація карпатської кухні, від''їзд.',
    target_audience = 'Туристи будь-якого віку, сім''ї з дітьми, любителі природи та фотографії, шукачі адреналіну'
WHERE slug = 'yaremche-group-tour';

-- Clear and repopulate attractions for Yaremche
DELETE FROM tour_proposal_attractions WHERE tour_proposal_id = (SELECT id FROM tour_proposals WHERE slug = 'yaremche-group-tour');
INSERT INTO tour_proposal_attractions (tour_proposal_id, attraction)
SELECT id, 'Водоспад Пробій — потужний водоспад на річці Прут' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'Гойдалка над водоспадом Пробій — популярна інста-локація' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'Сувенірний ринок гуцульських виробів' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'Стежка Довбуша — одна з найкрасивіших туристичних стежок Карпат' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'Музей «Карпати в мініатюрі» — міні-копії туристичних пам''яток' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'Буковель — популярний гірськолижний курорт' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'Гуцульські села та культурні локації' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'Гора Маковиця — піша прогулянка з краєвидами' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'Традиційна карпатська архітектура' FROM tour_proposals WHERE slug = 'yaremche-group-tour';

-- Clear and repopulate activities for Yaremche
DELETE FROM tour_proposal_activities WHERE tour_proposal_id = (SELECT id FROM tour_proposals WHERE slug = 'yaremche-group-tour');
INSERT INTO tour_proposal_activities (tour_proposal_id, activity)
SELECT id, 'Кінні прогулянки верхи, катання бричкою або санями' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'Джип-тури в гори з гідом' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'Квадроцикли — пригоди на гірських маршрутах' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'Риболовля' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'Фотосесії на гойдалці над водоспадом' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'Прогулянка містком над водоспадом' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'Відвідування сувенірного ринку' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'Піші маршрути стежкою Довбуша' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'Дегустація баношу та гуцульської кухні' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'Вільний час на природі та у селищі' FROM tour_proposals WHERE slug = 'yaremche-group-tour';

-- Clear and repopulate highlights for Yaremche
DELETE FROM tour_proposal_highlights WHERE tour_proposal_id = (SELECT id FROM tour_proposals WHERE slug = 'yaremche-group-tour');
INSERT INTO tour_proposal_highlights (tour_proposal_id, highlight)
SELECT id, 'Найпотужніший водоспад Карпат — Пробій' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'Інста-гідна локація — гойдалка над водоспадом' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'Поєднання природи та активностей' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'Гарячі фотографії з легендарною гойдалкою' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'Легенди про Олексу Довбуша під час походу' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'Традиційна гуцульська кухня та напої' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'Магічна атмосфера долини річки Прут' FROM tour_proposals WHERE slug = 'yaremche-group-tour'
UNION ALL SELECT id, 'Комфортна та насичена програма для всіх' FROM tour_proposals WHERE slug = 'yaremche-group-tour';

-- Update Synevyrska Polyana tour with detailed information
UPDATE tour_proposals
SET 
    description = 'Синевирська Поляна — мальовниче гірське селище в Закарпатській області, розташоване на території Національного природного парку «Синевир». Це місце славиться кришталево чистим повітрям, густими смерековими лісами, гірськими потоками та справжньою атмосферою карпатського спокою.',
    includes = 'Прибуття до селища Синевирська Поляна комфортабельним автобусом
Комфортне проживання
Найсмачніша гуцульська кухня (сніданки та вечері)
Трансфер по всьому маршруту
Супровід професійного гіда
Екскурсійна програма
Організаційний супровід групи',
    exclusions = 'Вхідні квитки
Майстер-класи
Джипи, чани, коні, квадроцикли
Дегустації
Особисті витрати',
    policy = 'Скасування за 14+ днів — повернення 100%
Скасування за 7–13 днів — повернення 50%
Скасування менше ніж за 7 днів — без повернення
Мінімальна група 15 осіб',
    program_details = 'День 1: Приїзд до Синевирської Поляни, знайомство з селищем та озером Синевир. День 2: Екологічні стежки довкола озера, реабілітаційний центр ведмедів, водоспад Шипіт. День 3: Екостежки парком, спілкування з мешканцями, придбання сувенірів, від''їзд.',
    target_audience = 'Туристи будь-якого віку, сім''ї з дітьми, любителі природи та спокійного відпочинку, екотуристи, люди, що цікавляться захистом дикої природи'
WHERE slug = 'synevyrska-polyana-group-tour';

-- Clear and repopulate attractions for Synevyrska Polyana
DELETE FROM tour_proposal_attractions WHERE tour_proposal_id = (SELECT id FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour');
INSERT INTO tour_proposal_attractions (tour_proposal_id, attraction)
SELECT id, 'Озеро Синевир — найбільше високогірне озеро України («Морське око»)' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'Дерев''яна скульптура «Синь і Вир» при озері' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'Реабілітаційний центр бурого ведмедя' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'Водоспад Шипіт та гірські потоки' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'Гора Гимба та гора Босничка — піші маршрути' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'Національний природний парк «Синевир»' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'Смерекові ліси та гірські пейзажи' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'Традиційна дерев''яна архітектура селища' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'Місцеві культурні локації та традиції' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour';

-- Clear and repopulate activities for Synevyrska Polyana
DELETE FROM tour_proposal_activities WHERE tour_proposal_id = (SELECT id FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour');
INSERT INTO tour_proposal_activities (tour_proposal_id, activity)
SELECT id, 'Екологічні стежки довкола озера Синевир' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'Прогулянки нацпарком с гідом' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'Спостереження за дикою природою' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'Посещення реабілітаційного центру ведмедів' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'Кінні прогулянки верхи' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'Джип-тури в гори з гідом' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'Риболовля' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'Дегустація закарпатських страв та напоїв' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'Неспішні піші маршрути лісом' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'Спілкування з місцевими жителями' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour';

-- Clear and repopulate highlights for Synevyrska Polyana
DELETE FROM tour_proposal_highlights WHERE tour_proposal_id = (SELECT id FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour');
INSERT INTO tour_proposal_highlights (tour_proposal_id, highlight)
SELECT id, 'Найбільше високогірне озеро України з кришталево чистою водою' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'Програма захисту дикої природи та ведмедів' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'Атмосфера спокою та гармонії з природою' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'Екотуристичні маршрути безпеки природи' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'Магічна красота гірських ландшафтів' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'Знайомство з програмою захисту редких видів' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'Справжня карпатська атмосфера без туристичної давки' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'Дегустація автентичної закарпатської кухні' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour'
UNION ALL SELECT id, 'Можливість придбати локальні сувеніри від майстрів' FROM tour_proposals WHERE slug = 'synevyrska-polyana-group-tour';
