
# NewShot 

Welcome to NewShot, your go-to app for the latest news and updates. Our app uses the https://newsapi.org/ to provide you with the latest stories from around the world, covering a wide range of topics such as politics, business, sports, technology, and more. With NewShot, you'll never miss a breaking story again. Stay informed, stay ahead, and stay connected with NewShot. 

## Features

- Smooth Onboarding 
- Clean User Interface
- View latest news according to categories 
- NewsApi gets the latest news asap!


## Screenshots

![App Screenshot]()


## Libraries used :

 - [Retrofit](https://github.com/square/retrofit)
 - [Picasso](https://github.com/square/picasso)

## API Reference

#### Get all news

```http
  @GET
    Call<NewsModal> getAllNews(@Url String url);
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `url` | `string` | API Key :  |62a221324a2141cfb2134e484eb32a03

#### Get news by categories

```http
  @GET
    Call<NewsModal> getNewsByCategory (@Url String url);
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `url`      | `string` | API Key :  |62a221324a2141cfb2134e484eb32a03|



## Clone this project :

Clone this project using CLI 

```bash
  git clone https://github.com/shreyxnsh/NewShot.git
```
    
