from selenium import webdriver
import pytest

@pytest.fixture(scope='module', params=[
    "file:///C:/coding/50003-elements-of-software-construction/pset3/src/q3/testing.html",
    "http://yarchitects.com/"
])
def input(request):
    return request.param

@pytest.fixture(scope='module', autouse=True)
def setup_driver(request):
    driver = webdriver.Firefox()
    subdriver = webdriver.Firefox()
    yield [driver, subdriver]
    driver.close()
    subdriver.close()

def test_input(input, setup_driver):
    setup_driver[0].get(input)
    links = setup_driver[0].find_elements_by_tag_name('a')
    for link in links:
        try:
            print(f"current link: {link.get_attribute('href')}")
            setup_driver[1].get(link.get_attribute('href'))
            print(f"Title: {setup_driver[1].title}")
            assert '<title>' in setup_driver[1].page_source
        except:
            continue
        



        

