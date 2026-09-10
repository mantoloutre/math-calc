//the "private variable" of an object in java
///Object Vector
///## param
///<p>x and y which represent the distance from 1 point to another</p>
/// (basically a vector usually points toward a point)
pub struct Vector {
    pub x: f64,
    pub y: f64,
}
impl Vector {
    pub fn new(x: f64, y: f64) -> Self {
        Self { x, y }
    }
    ///return the magnitude of the desired vector
    pub fn magnitude(&self) -> f64 {
        (self.x.powi(2) + self.y.powi(2)).sqrt()
    }
}


