mod models;

use crate::models::vector::Vector;
#[cfg_attr(mobile, tauri::mobile_entry_point)]
pub fn run() {
    tauri::Builder::default()
        .plugin(tauri_plugin_opener::init())
        .invoke_handler(tauri::generate_handler![
            magnitude
        ])
        .run(tauri::generate_context!())
        .expect("error while running tauri application");
}
#[tauri::command]
fn magnitude(x: f64, y: f64) -> f64 {
    Vector::new(x, y).magnitude()
}
