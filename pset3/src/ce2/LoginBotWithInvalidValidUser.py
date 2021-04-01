from selenium import webdriver
import pytest 

@pytest.fixture(scope='module', params=[
    {'username':'wrongusername','password':'wrongpassword'},
    {'username':'testingscript3000','password':'beepbeepboopboop'},
    {'username':'PowerfulAura','password':'WeakAura'}
])
def invalid_input(request):
    return request.param

@pytest.fixture(scope='module', params=[
    {'username':'coolESCtest','password':'TesterPassword'}
])
def valid_input(request):
    return request.param

@pytest.fixture(scope='module', autouse=True)
def setup_driver(request):
    driver = webdriver.Firefox()  
    yield driver
    driver.close() 

def test_invalid_input(invalid_input, setup_driver):
    setup_driver.get("https://statcounter.com/login/") 
    username = setup_driver.find_element_by_id('username')
    password = setup_driver.find_element_by_id('password')
    username.send_keys(invalid_input['username'])
    password.send_keys(invalid_input['password'])
    setup_driver.find_element_by_class_name("submit").click()
    
    assert 'Invalid Username or Password' in setup_driver.page_source 

def test_valid_input(valid_input, setup_driver):
    setup_driver.get("https://statcounter.com/login/") 
    username = setup_driver.find_element_by_id('username')
    password = setup_driver.find_element_by_id('password')
    username.send_keys(valid_input['username'])
    password.send_keys(valid_input['password'])
    setup_driver.find_element_by_class_name("submit").click()

    assert 'projects-page-header' in setup_driver.page_source 
