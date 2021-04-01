from selenium import webdriver
from random import randint

driver = webdriver.Firefox()
driver.get('https://istd.sutd.edu.sg/')
#links = driver.find_elements_by_xpath('//a[@href]')
links = driver.find_elements_by_tag_name('a')

while links is not None:
    random_link = links[randint(0, len(links)-1)]
    print(f"current link: {random_link.get_attribute('href')}")
    driver.get(random_link.get_attribute('href'))
    links = driver.find_elements_by_tag_name('a')
