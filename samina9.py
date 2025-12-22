from abc import ABC, abstractmethod


class Payment(ABC):
    @abstractmethod
    def pay(self, amount):
        pass

    @abstractmethod
    def refund(self, amount):
        pass


class CreditCardPayment(Payment):
    def pay(self, amount):
        print(f"Оплата {amount} сом с кредитной карты выполнена.")

    def refund(self, amount):
        print(f"Возврат {amount} сом на кредитную карту выполнен.")


class CryptoPayment(Payment):
    def pay(self, amount):
        print(f"Оплата {amount} сом в криптовалюте выполнена.")

    def refund(self, amount):
        print(f"Возврат {amount} сом в криптовалюте выполнен.")


payments = [CreditCardPayment(), CryptoPayment()]
for p in payments:
    p.pay(1000)
    p.refund(500)


class Course(ABC):
    @abstractmethod
    def start(self):
        pass

    @abstractmethod
    def get_materials(self):
        pass

    @abstractmethod
    def end(self):
        pass


class PythonCourse(Course):
    def start(self):
        print("Курс Python начался.")

    def get_materials(self):
        return ["Переменные", "Функции", "ООП", "Модули"]

    def end(self):
        print("Курс Python завершён.")


class MathCourse(Course):
    def start(self):
        print("Курс Математики начался.")

    def get_materials(self):
        return ["Алгебра", "Геометрия", "Тригонометрия"]

    def end(self):
        print("Курс Математики завершён.")


courses = [PythonCourse(), MathCourse()]
for c in courses:
    c.start()
    print(c.get_materials())
    c.end()


class Delivery(ABC):
    @abstractmethod
    def calculate_cost(self, distance):
        pass

    @abstractmethod
    def deliver(self):
        pass


class AirDelivery(Delivery):
    def calculate_cost(self, distance):
        return distance * 10

    def deliver(self):
        print("Доставка самолётом выполнена.")


class GroundDelivery(Delivery):
    def calculate_cost(self, distance):
        return distance * 5

    def deliver(self):
        print("Наземная доставка выполнена.")


class SeaDelivery(Delivery):
    def calculate_cost(self, distance):
        return distance * 3

    def deliver(self):
        print("Морская доставка выполнена.")


deliveries = [AirDelivery(), GroundDelivery(), SeaDelivery()]
for d in deliveries:
    print(d.calculate_cost(100))
    d.deliver()


class BankAccount:
    def __init__(self, owner, balance, pin):
        self.__owner = owner
        self.__balance = balance
        self.__pin = pin

    def deposit(self, amount, pin):
        if pin == self.__pin and amount > 0:
            self.__balance += amount
            print("Баланс пополнен.")
        else:
            print("Ошибка при пополнении.")

    def withdraw(self, amount, pin):
        if pin == self.__pin and 0 < amount <= self.__balance:
            self.__balance -= amount
            print("Деньги сняты.")
        else:
            print("Ошибка при снятии.")

    def change_pin(self, old_pin, new_pin):
        if old_pin == self.__pin:
            self.__pin = new_pin
            print("PIN изменён.")
        else:
            print("Неверный PIN.")


acc = BankAccount("Самина", 5000, 1234)
acc.deposit(2000, 1234)
acc.withdraw(1000, 1234)
acc.change_pin(1234, 5678)


class UserProfile:
    def __init__(self, email, password):
        self.__email = email
        self.__password = password
        self._status = "free"

    def login(self, email, password):
        if self.__email == email and self.__password == password:
            print("Вход выполнен.")
            return True
        else:
            print("Неверные данные.")
            return False

    def upgrade_to_premium(self):
        self._status = "premium"
        print("Аккаунт обновлён до Premium.")

    def get_info(self):
        return {"email": self.__email, "status": self._status}


user = UserProfile("samina@mail.com", "12345")
if user.login("samina@mail.com", "12345"):
    user.upgrade_to_premium()
print(user.get_info())


class Product:
    def __init__(self, name, price):
        self.name = name
        self.price = price
        self.__discount = 0

    def get_price(self):
        return self.price * (1 - self.__discount)

    def set_discount(self, discount, is_admin=False):
        if is_admin:
            self.__discount = discount
            print("Скидка установлена.")
        else:
            print("Нет доступа.")


p = Product("Ноутбук", 50000)
p.set_discount(0.1, is_admin=True)
print(p.get_price())


class TextFile:
    def open(self):
        print("Открыт текстовый файл.")


class ImageFile:
    def open(self):
        print("Открыт файл изображения.")


class AudioFile:
    def open(self):
        print("Открыт аудиофайл.")


def open_all(files):
    for f in files:
        f.open()


files = [TextFile(), ImageFile(), AudioFile()]
open_all(files)


class Car:
    def move(self, distance):
        speed = 100
        time = distance / speed
        print(f"Машина проедет {distance} км за {time:.2f} часов.")


class Truck:
    def move(self, distance):
        speed = 60
        time = distance / speed
        print(f"Грузовик проедет {distance} км за {time:.2f} часов.")


class Bicycle:
    def move(self, distance):
        speed = 20
        time = distance / speed
        print(f"Велосипед проедет {distance} км за {time:.2f} часов.")


def simulate_transport(transport_list, distance=120):
    for t in transport_list:
        t.move(distance)


simulate_transport([Car(), Truck(), Bicycle()])


class Student:
    def access_portal(self):
        print("Доступ: просмотр расписания и оценок.")


class Teacher:
    def access_portal(self):
        print("Доступ: выставление оценок и загрузка материалов.")


class Administrator:
    def access_portal(self):
        print("Доступ: управление пользователями и настройками системы.")


users = [Student(), Teacher(), Administrator()]
for u in users:
    u.access_portal()
