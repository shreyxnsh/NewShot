
# NewShot 

Welcome to NewShot, your go-to app for the latest news and updates. Our app uses the https://newsapi.org/ to provide you with the latest stories from around the world, covering a wide range of topics such as politics, business, sports, technology, and more. With NewShot, you'll never miss a breaking story again. Stay informed, stay ahead, and stay connected with NewShot. 

## Features

- Smooth Onboarding 
- Clean User Interface
- View latest news according to categories 
- NewsApi gets the latest news asap!


## Screenshots

![NewShot_Splash](https://user-images.githubusercontent.com/88729972/212486520-35219669-99ef-4cf9-8ef5-1cb2aaddb8a7.jpg)
![NewShot_OnBoard](https://user-images.githubusercontent.com/88729972/212486549-300389b8-5a14-4297-82e3-0266a10cc956.jpg)
![NewShot_Home](https://user-images.githubusercontent.com/88729972/212486546-a292d6e4-9f41-42ff-a35b-b1ed3d74d771.jpg)
![NewShot_Home2](https://user-images.githubusercontent.com/88729972/212486547-c8b7406a-ddc6-4a1f-835e-cef2e2327c0b.jpg)
![NewShot_Detailed](https://user-images.githubusercontent.com/88729972/212486544-6b7baa56-e0a5-4280-b84d-67a699c6f43d.jpg)


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
    
